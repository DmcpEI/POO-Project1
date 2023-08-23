import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    private GreenfootImage [] imagens;
    
    public Vida(){
     imagens = new GreenfootImage [4];
        
        for(int i =0;i<=3;i++){///percorre o array para guardar informaçao
            imagens[i] = new GreenfootImage("lives"+(i)+".png");
            imagens[i].scale(imagens[i].getWidth()/2,imagens[i].getHeight()/2);
        }
        
        setImage(imagens[0]);
    }
    
    public GreenfootImage [] getImagens(){ //retorna o array com imagens
        return imagens;
    }
    public void perdeVida(int hit){
        if (hit==3){//se ainda nao lhe batem
            setImage(getImagens()[0]);//barra com toda a vida
        }
        if(hit==2){ //batem-lhe uma vez 
            setImage(getImagens()[1]);//barra com uma vida menos
        }
        if (hit==1){//batem-lhe uma segunda vez
            setImage(getImagens()[2]);// barra com dus vidas menos
        }
        if (hit==0){//batem-lhe pela terceira vez
            setImage(getImagens()[3]);//barra sem vida
        }

        }
}
