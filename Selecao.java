import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selecao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selecao extends World
{
    private Player primeiraEscolha, segundaEscolha;
    
    public Selecao()
    {    
        super(768, 768, 1);
        setBackground("Fundo.png");
        prepareWorld();
    }
    
    public void prepareWorld(){
       
    addObject(new Cenario("Texto1SL.png",1),getWidth()/2,100);    
        
    addObject(new Personagem("P1 CARA",1),250,320);
    addObject(new Personagem("P2 CARA",2),getWidth() - 250,320);
    addObject(new Personagem("P3 CARA",3),250,getHeight() - 200);
    addObject(new Personagem("P4 CARA",4),getWidth() -250,getHeight() - 200);
    addObject(new SemEscolhaBT(),getWidth()/2,720);
    }
    
    public Player getPrimeiroPlayer(){
        return primeiraEscolha;
    }
    
    public void setPrimeiroPlayer(Player p){
        primeiraEscolha = p;
    }
    
    public Player getSegundoPlayer(){
        return segundaEscolha;
    }
    
    public void setSegundoPlayer(Player p){
        segundaEscolha = p;
    }
}
