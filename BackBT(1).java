import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackBT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackBT extends Botoes
{
    public BackBT(){
        super(new GreenfootImage[2],"BotaoBack",2);
    }
    
    public void act()
    {
        mouseToca();
        clickButton();
    }
    
    public void clickButton()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu());
        }
    }
}
