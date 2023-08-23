import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controlos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controlos extends World
{

    /**
     * Constructor for objects of class Controlos.
     * 
     */
    public Controlos()
    {    
        super(768, 768, 1); 
        setBackground("Fundo.png");
        prepareWorld();
    }
    public void prepareWorld(){
        
        addObject(new Cenario("Chain.png",4),332,392);
        addObject(new Cenario("controls_.png",1),389,381);
        addObject(new BackBT(),getWidth()/2,680);
    }
}
