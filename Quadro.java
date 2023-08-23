import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class quadro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quadro extends Actor
{
    public Quadro (String a, int scale){// criar os quadros com as perguntas
        GreenfootImage imagem = new GreenfootImage(a);
        imagem.scale(imagem.getWidth()/scale,imagem.getHeight()/scale);
        setImage(imagem);
    }
}
