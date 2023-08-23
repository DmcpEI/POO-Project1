import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AVermelha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AVermelha extends Acionaveis
{
    public AVermelha(){
        super(new GreenfootImage [2],"RedLever",14);
    }

    public void puxarLever(boolean puxar){
        if(puxar){
            setImage(getImagens()[1]);
        }
        else{
            setImage(getImagens()[0]);
        }
    }
}
