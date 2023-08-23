import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victory extends World
{
    private int score;

    public Victory(Player a, Player b,int s)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 900, 1);
        score = s;
        prepareWorld(a,b);
        showText("Score:" + score,getWidth() / 2, 800);
    }
    private void prepareWorld(Player a, Player b){
        setBackground("mathieu-chauderlot-room-0013-layer-15.jpg");
        addObject(new Cenario("Victory.png",1),getWidth()/2,320);
        addObject(new RestartBT(),getWidth()/2,620);
        addObject(a,408,450);
        addObject(b,495,450);
    }    
}

