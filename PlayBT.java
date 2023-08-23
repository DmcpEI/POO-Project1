import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayBT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayBT extends Botoes
{
    public PlayBT(){
        super(new GreenfootImage[2],"BotaoPlay",1);
    }
    
    public void act()
    {
        mouseToca();
        somClica();
        clickButton();
    }
    
    public void clickButton()// // mudar para Selecao se clicar o botao 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Selecao());
        }
    }
}
