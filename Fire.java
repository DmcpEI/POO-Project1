import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Inimigo
{
    public Fire(){
        super(new GreenfootImage [3],"Fire");
    }
    
    public void act(){
        anima();
    }
}
