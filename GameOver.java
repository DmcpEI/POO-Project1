import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int tipo)
    {    
        super(900, 900, 1); 
        //addObject(new Cenario("DinosaurWarning.png",2),750,100);
        //addObject(new Cenario("GasMask.png",3),150,800);
        if(tipo == 1){
            setBackground("RaptorBack.jpg");
        }
        else if (tipo == 2){
            setBackground("BlackBack.jpg");
        }
        addObject(new Cenario("Game Over.png",1),getWidth()/2,320);
        addObject(new RestartBT(),getWidth()/2,620);
    }
}
