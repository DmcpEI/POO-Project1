import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stamina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stamina extends Actor
{
private GreenfootImage [] imagens;
    private int player;
    private int nivelStamina;
    
    private int contador;
    private int indice;
    
    public Stamina(int p){
        imagens = new GreenfootImage [6];
        player = p;
        nivelStamina = 6;
        
        for(int i = 0;i<imagens.length;i++){//percorre um array para adicionar informação
            imagens[i] = new GreenfootImage("Stamina"+(i+1)+".png");
            imagens[i].scale(imagens[i].getWidth()/3,imagens[i].getHeight()/3);
        }
        
        setImage(imagens[0]);
    }
    
    public void act(){
        perdeStamina();
        ganhaStamina();
    }
    
    public GreenfootImage [] getImagens(){//retorna o array imagens
        return imagens;
    }
    
    public void perdeStamina(){//verifica o valor da stamina do player e muda a imagem da stamina consoante essa
        if(player == 1){
            if(getWorld().getObjects(Player.class).get(0).getStamina()==50){
            setImage(getImagens()[0]);
            nivelStamina=5;
            }
            if (getWorld().getObjects(Player.class).get(0).getStamina()==40){
            setImage(getImagens()[1]);
            nivelStamina=4;
            }
            if (getWorld().getObjects(Player.class).get(0).getStamina()==30){
            setImage(getImagens()[2]);
            nivelStamina=3;
            }
            if (getWorld().getObjects(Player.class).get(0).getStamina()==20){
            setImage(getImagens()[3]);
            nivelStamina=2;
            }
            if (getWorld().getObjects(Player.class).get(0).getStamina()==10){
            setImage(getImagens()[4]);
            nivelStamina=1;
            }
            if (getWorld().getObjects(Player.class).get(0).getStamina()==0){
            setImage(getImagens()[5]);
            nivelStamina=0;
            }
        }
        if(player == 2){
            if(getWorld().getObjects(Player.class).get(1).getStamina()==50){
            setImage(getImagens()[0]);
            nivelStamina=5;
            }
            if (getWorld().getObjects(Player.class).get(1).getStamina()==40){
            setImage(getImagens()[1]);
            nivelStamina=4;
            }
            if (getWorld().getObjects(Player.class).get(1).getStamina()==30){
            setImage(getImagens()[2]);
            nivelStamina=3;
            }
            if (getWorld().getObjects(Player.class).get(1).getStamina()==20){
            setImage(getImagens()[3]);
            nivelStamina=2;
            }
            if (getWorld().getObjects(Player.class).get(1).getStamina()==10){
            setImage(getImagens()[4]);
            nivelStamina=1;
            }
            if (getWorld().getObjects(Player.class).get(1).getStamina()==0){
            setImage(getImagens()[5]);
            nivelStamina=0;
            }
        }
    }
    
    public void ganhaStamina(){//verifica o nivelStamina e se o Player esta parado, utilizando um contador para preencher a barra
        if(player == 1 && nivelStamina<6 && getWorld().getObjects(Player.class).get(0).parado()){
            contador++;
            if(contador == 55){
                nivelStamina++;
                getWorld().getObjects(Player.class).get(0).setStamina(nivelStamina*10);
                contador=0;
            }
        }
        else if(player == 2 && nivelStamina<6 && getWorld().getObjects(Player.class).get(1).parado()){
            contador++;
            if(contador == 55){
                nivelStamina++;
                getWorld().getObjects(Player.class).get(1).setStamina(nivelStamina*10);
                contador=0;
            }
        }
    }
}