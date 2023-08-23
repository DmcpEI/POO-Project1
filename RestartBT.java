import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartBT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartBT extends Botoes
{
    public RestartBT(){
        super(new GreenfootImage [2],"BotaoRestart",1);
    }
    
    public void act(){
        mouseToca();
        somClica();
        clickButton();
    }
    
    public void clickButton(){  
        if(Greenfoot.mouseClicked(this) && this.getWorld().getClass() ==  GameOver.class){ //mudar para o menu desde o GameOver 
            Greenfoot.setWorld(new Menu());
            Greenfoot.playSound("SomRestart.mp3");
        }
        else if(this.getWorld().getClass() ==  Victory.class){ //mudar para o menu desde o Victory
            if(intersects(getWorld().getObjects(Player.class).get(0))  && intersects(getWorld().getObjects(Player.class).get(1))){ // quando player1 e o player2 estao por cima do botao
                setImage(getImagens()[1]); //muda a imagem
                if(Greenfoot.isKeyDown("E") && Greenfoot.isKeyDown("0")){//mudar para o menu quado o player1 e o player2 precionarem no "E" e no "0"
                    Greenfoot.setWorld(new Menu());//muda de undo para o menu
                    Greenfoot.playSound("SomRestart.mp3");//som 
                }
            }
            else{
                setImage(getImagens()[0]);//muda de imagem
            }
        }
    }
}
