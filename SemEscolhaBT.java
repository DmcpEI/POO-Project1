import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SemEscolhaBT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SemEscolhaBT extends Botoes
{
    public SemEscolhaBT(){
        super(new GreenfootImage [2],"BotaoSemEscolha",1);
    }
    
    public void act(){
        mouseToca();
        somClica();
        clickButton();
    }
    
    public void clickButton()
    {
        if(Greenfoot.mouseClicked(this)){
            if(getWorldOfType(Selecao.class).getPrimeiroPlayer() != null){// só ecolhe o primeiro
                Greenfoot.setWorld(new Labirinto(getWorldOfType(Selecao.class).getPrimeiroPlayer()));//muda para o labirinto
            }
            else{
                Greenfoot.setWorld(new Labirinto());//nao escolhem, muda de mundo para o labirinto
            }
        }
    }
}
