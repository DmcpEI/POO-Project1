import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Placa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Placa extends Acionaveis
{
    private boolean pisou;
    
    public Placa(){
        super(new GreenfootImage [2],"Placa",2);
    }
    
    public void act()
    {
        pisaPlaca();
    }
    
    public void pisaPlaca(){
        if (isTouching(Player.class)){
            setImage(getImagens()[1]);
            Greenfoot.playSound("SomPlaca.mp3");
            getWorld().removeObjects(getWorld().getObjects(Fire.class));
            pisou = true;
        }
        else{
            if (pisou==true){
                setImage(getImagens()[0]);
                getWorld().addObject(new Fire(), 194,827);
                pisou=false;
            }
        }  
    }
}
