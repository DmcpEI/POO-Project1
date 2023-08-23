import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barreiras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barreiras extends Actor
{
    private GreenfootImage [] imagens;
    private boolean aberta;
    private boolean abriu;
    
    public Barreiras(GreenfootImage [] a, String barreira){//array de imagens
        imagens = a;
        
        imagens[0] = new GreenfootImage(barreira+"Fechada.png");
        imagens[1] = new GreenfootImage(barreira+"Aberta.png");
        
        setImage(imagens[0]);
    }
    
    public GreenfootImage [] getImagens(){//retornar o array
        return imagens;
    }
    
    public void abrirBarreira(boolean abrir){ // animaçao para abrir a barreira e adicionar pontos ao score
        if(abrir){
            setImage(getImagens()[1]);
            aberta = true;
            if(!abriu){
                getWorldOfType(Labirinto.class).somaPontos(300);
                abriu = true;
            }
        }
        else{
            setImage(getImagens()[0]);
            aberta = false;
        }
    }
    
    public boolean getAberta(){ // retornar aberta
        return aberta;
    }
}
