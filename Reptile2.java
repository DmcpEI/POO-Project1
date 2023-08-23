import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reptile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reptile2 extends Inimigo
{
    private int verifica;
    
    public Reptile2(){
        super(new GreenfootImage [3], "Reptile2");
    }
    
    @Override 
    public void movimento(){//metodo com override para o inimigo se mover de cima para baixo
        if (verifica%2!=0){//se o resto da divissao é 0 
            setLocation(getX(), getY()-2); //move-se para baixo
            anima(); 
            if (hitMuroLB()){//se bate no muro 
                turn(180);//gira 180
                verifica++;//aumenta o verifica
            }
        }
        else{//se o numero é impar 
            setLocation(getX(), getY()+2); //move-se para cima
            anima();
            if (hitMuroLB()){// se bate no muro
                turn(180);//gira 180
                verifica++;//aumenta o verifica
            }
        }
    }
}
