import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bau extends Acionaveis
{
    private boolean abriu;
    
    public Bau(){
        super(new GreenfootImage [2],"bau",2);
    }

    public void abrir_bau(boolean abrir){// animaçao para abrir e fechar o abu
        if(abrir){
            setImage(getImagens()[1]);
            Greenfoot.playSound("SomBauAbrir.mp3");
            if(!abriu){
                getWorldOfType(Labirinto.class).somaPontos(300);
                abriu = true;
            }
        }
        else{
            setImage(getImagens()[0]);
        }
    }
}
