import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Labirinto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Labirinto extends World
{
    private int score;
    private int INITIAL_SCORE = 0;
    private int nivel;
    
    public Labirinto(Player a, Player b)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 900, 1); 
        setBackground("FundoLB.png");
        score=INITIAL_SCORE;
        prepareWorld(a,b);
        nivel = 1;
    }
    
    public Labirinto(){
        super(900, 900, 1); 
        setBackground("FundoLB.png");
        score=INITIAL_SCORE;
        prepareWorld(new Player(1,1),new Player(2,2));
        nivel = 1;
    }
    
    public Labirinto(Player a){
        super(900, 900, 1); 
        setBackground("FundoLB.png");
        score=INITIAL_SCORE;
        prepareWorld(a,new Player(2,2));
        nivel = 1;
    }
    
    private void prepareWorld(Player a, Player b){
        addObject(new Placa(),69,842);
        addObject(new Bau(),335,788);
        addObject(new Porta(),450,450);
        addObject(a,65,85);
        addObject(b,832,816);
        //Adicionar os dinossauros
        addObject(new Reptile1(),303,690);
        addObject(new Reptile1(),700,284);
        addObject(new Reptile2(),85,322);
        
        //Adicionar as caixas para criar o labirinto
        for(int i=844;i>600;i-=30)
        addObject(new Cenario("Box.jpg",6),768,i);
        for(int i=664;i<850;i+=30)
        addObject(new Cenario("Box.jpg",6),i,483);
        for(int i=483;i<620;i+=30)
        addObject(new Cenario("Box.jpg",6),664,i);
        for(int i=664;i>300;i-=30)
        addObject(new Cenario("Box.jpg",6),i,630);
        for(int i=648;i>492;i-=30)
        addObject(new Cenario("Box.jpg",6),i,745);
        for(int i=198;i<400;i+=30)
        addObject(new Cenario("Box.jpg",6),i,745);
        for(int i=745;i>530;i-=30)
        addObject(new Cenario("Box.jpg",6),198,i);
        
        addObject(new Cenario("Box.jpg",6),648,782);
        addObject(new Cenario("Box.jpg",6),648,813);
        addObject(new Cenario("Box.jpg",6),648,844);
        addObject(new Cenario("Box.jpg",6),378,782);
        addObject(new Cenario("Box.jpg",6),378,813);
        addObject(new Cenario("Box.jpg",6),378,844);
        
        addObject(new Cenario("Box.jpg",6),55,140);
        for(int i=55;i<256;i+=30)
        addObject(new Cenario("Box.jpg",6),i,140);
        for(int i=140;i<400;i+=30)
        addObject(new Cenario("Box.jpg",6),256,i);
        for(int i=54;i<224;i+=30)
        addObject(new Cenario("Box.jpg",6),359,i);
        for(int i=340;i<500;i+=30)
        addObject(new Cenario("Box.jpg",6),359,i);
        for(int i=359;i<800;i+=30)
        addObject(new Cenario("Box.jpg",6),i,340);
        for(int i=510;i>250;i-=30)
        addObject(new Cenario("Box.jpg",6),161,i);
        
        addObject(new Cenario("Box.jpg",6),126,271);
        addObject(new Cenario("Box.jpg",6),100,271);
        
        for(int i=198;i<580;i+=30)
        addObject(new Cenario("Box.jpg",6),i,510);
        for(int i=479;i<600;i+=30)
        addObject(new Cenario("Box.jpg",6),i,204);
        for(int i=204;i>120;i-=30)
        addObject(new Cenario("Box.jpg",6),599,i);
        for(int i=599;i<900;i+=30)
        addObject(new Cenario("Box.jpg",6),i,144);
        
        addObject(new Cenario("Box.jpg",6),779,305);
        addObject(new Cenario("Box.jpg",6),779,269);
        addObject(new Cenario("Box.jpg",6),54,745);
        addObject(new Cenario("Box.jpg",6),90,745);
        
        //Muros damDireita
        for (int i=18;i<910;i+=30)  
            addObject(new Cenario("muros_lb.png",6),881,i);
        //Muros da Esquerda
        for(int i=18;i<910;i+=30)
            addObject(new Cenario("muros_lb.png",6),18,i);
        //Muro de Cima
        for(int i=18;i<910;i+=30)
            addObject(new Cenario("muros_lb.png",6),i,18);
        //Muro de Baixo
        for(int i=18;i<910;i+=30)
            addObject(new Cenario("muros_lb.png",6),i,881);
        //Adicionar Alavancas
        addObject(new AlavancaVermelha(),590,846);
        addObject(new AlavancaAzul("BlueLever"),836,109);
        //Adicionar as Barreiras
        addObject(new BVermelha(),210,278);
        addObject(new BAzul(),831,281);
        //indentificaçao das barras
        addObject(new Cenario("Player1.png",3),43,18);
        addObject(new Cenario("Player2.png",3),852,881);
        //stamina para cada player
        addObject(new Stamina(1),174,17);
        addObject(new Stamina(2),719,881);
        //Vida para cada Player
        addObject(new Vida(),108,18);
        addObject(new Vida(),783,881);
        //Adicionar fire
        addObject(new Fire(),194,824);
        //score
        showText("Score:" + score,getWidth() / 2, 15);
    }
    
    public void somaPontos(int pontos){// adicionar pontos
        score = score + pontos;//adicionar pontos
        if(score < 0){//nao ter escore negativo
            score=0;
        }
        showText("Score:" + score,getWidth() / 2, 15);
    }
    
    public int getScore(){//retornar score
        return score;
    }
    
    public int getNivel(){//retornar nivel
        return nivel;
    }
}
