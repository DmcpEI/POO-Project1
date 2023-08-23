import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    
    public Menu()
    {    
        super(768, 768, 1); 
        setBackground("Fundo.png");
        prepareWorld();
    }
    
    public void prepareWorld(){
        
        addObject(new Cenario("Chain.png",4),332,392);
        addObject(new Cenario("Blood.png",2),250,20);
        addObject(new Cenario("titulo_.png",1),467,67);
        addObject(new Cenario("J_G (2).png",4),384,660);
        
        addObject(new PlayBT(),getWidth()/2,380);
        addObject(new ControlosBT(),getWidth()/2,530);
        

    }
}
