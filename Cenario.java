import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario extends Actor
{
    public Cenario(String a, int scale){// cria objetos em um array
        GreenfootImage imagem = new GreenfootImage(a);
        imagem.scale(imagem.getWidth()/scale,imagem.getHeight()/scale);
        setImage(imagem);
    }
}
