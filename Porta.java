import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Porta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Porta extends Actor
{
    private boolean respostaL1, respostaL2, respostaL3;
    private boolean respostaR1, respostaR2, respostaR3;
    private boolean respostaC1, respostaC2, respostaC3; 
    
    public Porta(){
        GreenfootImage imagem = new GreenfootImage("Porta.png");
        imagem.scale(imagem.getWidth()/6,imagem.getHeight()/6);
        setImage(imagem);
    }
    
    public void act(){
        passarPorta();
    }
    
    public void passarPorta(){
    if(getWorld().getClass() == Labirinto.class){//se aporta esta no lbirinto
        if((getWorld().getObjects(Player.class).get(0).getKey() == 1) || (getWorld().getObjects(Player.class).get(1).getKey() == 1)){// se algum dos players tem a chave
            if(intersects(getWorld().getObjects(Player.class).get(0)) && intersects(getWorld().getObjects(Player.class).get(1))){//se os dois players tocam a porta
                getWorldOfType(Labirinto.class).somaPontos(1000);//adiciona 1000 pontos para o score
                Greenfoot.playSound("SomPorta.mp3");//som
                Greenfoot.setWorld(new CamaraGas(getWorld().getObjects(Player.class).get(0),getWorld().getObjects(Player.class).get(1),getWorldOfType(Labirinto.class).getScore()));// mudar os players para a camara de gas
            }
        }
    }
    if(getWorld().getClass() == CamaraGas.class){//se aporta esta na camara de gas
            if(passou()){//se conseguiram responder as perguntas
            if(intersects(getWorld().getObjects(Player.class).get(0)) && intersects(getWorld().getObjects(Player.class).get(1))){//os dois players estao a tocar a porta
                getWorldOfType(CamaraGas.class).somaPontos(1000);//adiciona 1000 pontos para o score
                Greenfoot.playSound("SomVitoria.mp3");// som
                Greenfoot.setWorld(new Victory(getWorld().getObjects(Player.class).get(0),getWorld().getObjects(Player.class).get(1),getWorldOfType(CamaraGas.class).getScore()));//mudar os players para o Victory
             }
        }
    }
    }
    
    public void setResposta(String a, boolean b){ // devolve as respostas 
        if(a == "C1"){
            respostaC1=b;
        }
        else if(a == "C2"){
            respostaC2=b;
        }
        else if(a == "C3"){
            respostaC3=b;
        }
        else if(a == "L1"){
            respostaL1=b;
        }
        else if(a == "L2"){
            respostaL2=b;
        }
        else if(a == "L3"){
            respostaL3=b;
        }
        else if(a == "R1"){
            respostaR1=b;
        }
        else if(a == "R2"){
            respostaR2=b;
        }
        else if(a == "R3"){
            respostaR3=b;
        }
    }
    
    public boolean passou(){ // compara as respostas para ver se estao certas
        if(respostaC1 && respostaC2 && respostaC3 && respostaL1 && respostaL2 && respostaL3 && respostaR1 && respostaR2 && respostaR3){
            return true;
        }
        else{
            return false;
        }
    }
}

