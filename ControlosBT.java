import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlosBT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlosBT extends Botoes
{
    public ControlosBT(){
        super(new GreenfootImage[2],"BotaoControlos",1);
    }
    
    public void act()
    {
        mouseToca();
        somClica();
        clickButton();
    }
    
    public void clickButton()// mudar de mundo se clicar no botao
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Controlos());
        }
    }
}
