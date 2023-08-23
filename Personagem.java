import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem extends Botoes
{
    private int player;
    
    public Personagem(String cara, int play){
        super(new GreenfootImage[2],cara,1);
        player = play;  
    }
    
    public void act()
    {
        mouseToca();
        escolhe();
    }
    
    private void escolhe(){//escolher personagem
        if (Greenfoot.mouseClicked(this)){//verifica se o botao foi clicado
            somClica();//som do botao
            if(getWorldOfType(Selecao.class).getPrimeiroPlayer() == null){
                Player Player1 = new Player(player,1);// cria o player 1
                getWorldOfType(Selecao.class).setPrimeiroPlayer(Player1); // guarda a personagem escolhida para o player 1
                getWorld().removeObjects(getWorld().getObjects(Cenario.class)); //remove o botao da personagem escolhida
                Cenario texto2 = new Cenario("Texto2SL.png",1);  // cria o texto
                getWorld().addObject(texto2,getWorld().getWidth()/2,100);// adiciona um texto para escolher o segundo jogador
                getWorld().removeObject(this);
            }
            else{
                Player Player2 = new Player(player,2);// cria o player 2 
                getWorldOfType(Selecao.class).setSegundoPlayer(Player2);//guarda a personagem escolhida para o player 2
                Greenfoot.setWorld(new Labirinto(getWorldOfType(Selecao.class).getPrimeiroPlayer(),getWorldOfType(Selecao.class).getSegundoPlayer()));//remove o botao da personagem escolhida
            }
        }
    }
}
