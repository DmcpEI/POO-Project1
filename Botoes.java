import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botoes extends Actor
{
    private GreenfootImage [] imagens;
    
    public Botoes(GreenfootImage [] a, String imagem, int scale){// array de imagens
        imagens = a;
        
        imagens[0] = new GreenfootImage(imagem+"1.png");
        imagens[0].scale(imagens[0].getWidth()/scale,imagens[0].getHeight()/scale);
        imagens[1] = new GreenfootImage(imagem+"2.png");
        imagens[1].scale(imagens[0].getWidth()/scale,imagens[0].getHeight()/scale);
        
        setImage(imagens[0]);
    }
    
    public void mouseToca(){// metodo que verifica se o rato esta por cima do botao 
        if(this.getWorld().getClass() !=  Victory.class){
        if(Greenfoot.mouseMoved(this)){
            setImage(imagens[1]);
        }
        else if(Greenfoot.mouseMoved(null)){
            setImage(imagens[0]);
        }
        }
    }
    
    public GreenfootImage [] getImagens(){//retornar o array 
        return imagens;
    }
    
    public void somClica(){// som dos botoes 
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("SomBotao.mp3");
        }
    }
}
