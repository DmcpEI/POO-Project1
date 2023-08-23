import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CamaraGas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CamaraGas extends World
{   SimpleTimer tim=new SimpleTimer();
    Counter timeCount = new Counter();
    private int start=0;
    private int gas;
    
    private int score;
    private int nivel;
    
    public CamaraGas(Player a, Player b, int s)
    {    
        super(900, 900, 1); 
        setBackground("FundoLB.png");
        score = s;
        prepareWorld(a,b);
        addObject(timeCount,646,12);
        nivel = 2;
    }
    public void act(){
      start=1;
      timer();
    }
    private void prepareWorld(Player a, Player b){
        // Adicionar as alavncas. 
        addObject(new AlavancaRoxa(),(getWidth()/2)-100,300);
        addObject(new AlavancaRoxa(),getWidth()/2,300); 
        addObject(new AlavancaRoxa(),(getWidth()/2)+100,300);
        addObject(new AlavancaCastanha(),(getWidth()/2)-100,400);
        addObject(new AlavancaCastanha(),getWidth()/2,400);
        addObject(new AlavancaCastanha(),(getWidth()/2)+100,400);
        addObject(new AlavancaLaranja(),(getWidth()/2)-100,500);
        addObject(new AlavancaLaranja(),getWidth()/2,500);
        addObject(new AlavancaLaranja(),(getWidth()/2)+100,500);
        
        // Adicionar muros a Direita
        for (int i=18;i<910;i+=30)  
            addObject(new Cenario("muros_lb.png",6),881,i);
        //Adicionar muros a Esquerda
        for(int i=18;i<910;i+=30)
            addObject(new Cenario("muros_lb.png",6),18,i);
        //Adicionar muros a Cima
        for(int i=18;i<910;i+=30)
            addObject(new Cenario("muros_lb.png",6),i,18);
        //Adicionar muros a Baixo
        for(int i=18;i<910;i+=30)
        addObject(new Cenario("muros_lb.png",6),i,881);
        
        addObject(new Cenario("Player1.png",3),43,18); 
        addObject(new Cenario("Player2.png",3),852,881);
        addObject(new Vida(),108,18);// Adicionar barra de vida do primer jogador
        addObject(new Vida(),783,881);// Adicionar barra de vida do segundo jogador
        addObject(new Stamina(1),174,17);// Adicionar stamina do primer jogador
        addObject(new Stamina(2),719,881);// Adicionar stamina do segundo jogador
        //Adicionar botões
        addObject(new BotaoLaranja(),80,450);
        addObject(new BotaoCastanho(),getWidth()-80,450);
        addObject(new BotaoRoxo(),getWidth()/2,80);
        
        addObject(new Porta(),getWidth()/2,150);//Adicionar Porta 
        addObject(a,408,450); // adicionar player 1
        addObject(b,495,450);// adicionar player 2
        showText("Score:" + score,getWidth() / 2, 15);//adicionar score
    }
    
    public void timer(){
        if (start==1){// ativar o gas
        timeCount.setValue(tim.millisElapsed()/1000);//colocar o tempo em segundos
        if (tim.millisElapsed()>1000*10 && gas ==0){//adicionar gas depois de 10 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,830);
        gas=1;// variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
        
        if (tim.millisElapsed()>(1000*10)*2 && gas ==1){//adicionar gas depois de 20 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,766);
        gas=2;
        somaPontos(-100);//retirar pontos
        }
        if (tim.millisElapsed()>(1000*10)*3 && gas ==2){//adicionar gas depois de 30 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,699);
        gas=3;// variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
        if (tim.millisElapsed()>(1000*10)*4 && gas ==3){//adicionar gas depois de 40 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,624);
        gas=4;// variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
        if (tim.millisElapsed()>(1000*10)*5 && gas ==4){//adicionar gas depois de 50 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,552);
        gas=5;// variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
        if (tim.millisElapsed()>(1000*10)*6 && gas ==5){//adicionar gas depois de 60 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,482);
        gas=6;// variavel para parar o gas
        somaPontos(-100);//retirar pontos
            }
          if (tim.millisElapsed()>(1000*10)*7 && gas ==6){//adicionar gas depois de 70 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,417);
        gas=7; // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
          if (tim.millisElapsed()>(1000*10)*8 && gas ==7){//adicionar gas depois de 80 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,344);
        gas=8;  // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
          if (tim.millisElapsed()>(1000*10)*9 && gas ==8){//adicionar gas depois de 90 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,270);
        gas=9;  // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
          if (tim.millisElapsed()>(1000*10)*10 && gas ==9){//adicionar gas depois de 100 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,210);
        gas=10;  // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
          if (tim.millisElapsed()>(1000*10)*11 && gas ==10){//adicionar gas depois de 110 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,132);
        gas=11;  // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
          if (tim.millisElapsed()>(1000*10)*12 && gas ==11){//adicionar gas depois de 120 segundos
        for(int i=85;i<830;i+=60)
        addObject(new Gas(), i,65);
        gas=12;  // variavel para parar o gas
        somaPontos(-100);//retirar pontos
        }
        }
    }
    
    public void somaPontos(int pontos){//adicionar pontos
        score = score + pontos;//adicionar pontos
        if(score < 0){//nao ter escore negativo
            score=0;
        }
        showText("Score:" + score,getWidth() / 2, 15);// mostrar o score
    }
    
    public int getScore(){//retornar score
        return score;
    }
    
    public int getNivel(){//retornar score
        return nivel;
    }
}
