import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Acionaveis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acionaveis extends Actor
{
    private GreenfootImage [] imagens;
    private boolean tocou;
    public Acionaveis(GreenfootImage [] a, String nome, int scale){// criar array de imagens
        imagens = a;
        for(int i = 0;i<imagens.length;i++){
            imagens[i] = new GreenfootImage(nome+(i+1)+".png");
            imagens[i].scale(imagens[i].getWidth()/scale,imagens[i].getHeight()/scale);
        }
        setImage(imagens[0]);
    }
    
    public GreenfootImage [] getImagens(){// retornar o array 
        return imagens;
    }
    
    public void puxarLever(boolean puxar){// animaçao da alavanca 
        if(puxar){
            setImage(getImagens()[1]);
            Greenfoot.playSound("SomAlavanca.mp3");
        }
        else{
            setImage(getImagens()[0]);
            Greenfoot.playSound("SomAlavanca.mp3");
        }
    }
}
