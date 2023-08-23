import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monstros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Actor
{
    private GreenfootImage [] imagens;
    private int indice;
    private int contador;
    
    public Inimigo( GreenfootImage [] a, String nome){ 
        imagens = a;
        for(int i = 0;i<imagens.length;i++){//percorre o array para guardar informaçao
            imagens[i] = new GreenfootImage(nome+" "+(i+1)+".png");
            imagens[i].scale(imagens[i].getWidth() - 20,imagens[i].getHeight() - 20);
        }
        setImage(imagens[0]);//primera imagem do array 
    }
    
    public void act(){
        movimento();
    }
    
    public void anima(){ //animaçao de movimento
        contador++;
        if(contador == 5){
            
        indice++;
        
        if (indice >= imagens.length )
        {
            indice = 0;
        }

        setImage(imagens[indice]);
        contador = 0;
        }
    }
    
    public boolean hitMuroLB(){//para saber se bate nos muros
        if (isTouching(Cenario.class))//se toca true
        return true;
        else// se nao toca false
        return false;
    }
    
    public GreenfootImage [] getImagens(){//retorna o array de imagens
        return imagens;
    }
    
    public void movimento(){//movimento
        move(3);
        anima();
        if (hitMuroLB()){//se bate no muro gira faz espelho das imagens
            turn (180);
            getImagens()[0].mirrorVertically();
            getImagens()[1].mirrorVertically();
            getImagens()[2].mirrorVertically();
            getImagens()[3].mirrorVertically();
        }
    }
}
