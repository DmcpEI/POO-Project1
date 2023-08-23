import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private GreenfootImage [] imagensF;
    private GreenfootImage [] imagensE;
    private GreenfootImage [] imagensD;
    private GreenfootImage [] imagensT;
    
    private int indice;
    private int contador;
    private int key;
    private int player;
    private boolean tocouLeverV;
    private boolean tocouLeverA;
    private boolean tocoubau;
    private boolean tocouquadroL;
    private boolean tocouquadroC;
    private boolean tocouquadroR;

    private int status;
    private int statusBau;
    private int corre;
    private int playerLives;
    private int status_quadro;
    private boolean tocouLeverL1, tocouLeverL2, tocouLeverL3;
    private boolean tocouLeverR1, tocouLeverR2, tocouLeverR3;
    private boolean tocouLeverC1, tocouLeverC2, tocouLeverC3;
    private int status2;
    private boolean respostaL1, respostaL2, respostaL3;
    private boolean respostaR1, respostaR2, respostaR3;
    private boolean respostaC1, respostaC2, respostaC3; 
    private int stamina;
    private boolean tocaBotao;
    private int nivel;
   
    
    
    public Player(int person, int play){
        player = play;
        
        imagensF = new GreenfootImage [3];
        imagensE = new GreenfootImage [3];
        imagensD = new GreenfootImage [3];
        imagensT = new GreenfootImage [3];
        
        animacao(person);
    
        setImage(imagensF[0]);
        playerLives=3;
        stamina=60;
    }
    
    public void act()
    {
        checkKeyPress(player);
        correr(player);
        ativaLever(player);
        playerHit(player);
        abrirBau(player);
        removeKey();
        abrirQuadro(player);
        ativaLever2(player);
        mundo();
    }
    
    public boolean hitMuroLB(){// verifica se bate no muro 
        if (isTouching(Cenario.class))//bate nas caixas
        return true;
        else if (isTouching(BVermelha.class) && getWorld().getObjects(BVermelha.class).get(0).getAberta() == false)//bate na barreira
        return true;
        else if (isTouching(BAzul.class) && getWorld().getObjects(BAzul.class).get(0).getAberta() == false)//bate na barreira 
        return true;
        else//nao bate
        return false;
    }
    
    public boolean hitEnemy()
    {
        if(isTouching(Reptile1.class) || isTouching(Reptile2.class)){//bate nos dinossauros
            Greenfoot.playSound("SomReptile.mp3");//som
            return true;
        }
        else if(isTouching(Fire.class)){//bate no fogo
            Greenfoot.playSound("SomFogo.mp3");//som
            return true;
        }
        else if(isTouching(Gas.class)){// toca o gas
            Greenfoot.playSound("SomGas.mp3");//som
            return true;
        }
        else{//nao bate 
            return false;
        }
    }
    
    public void anima(GreenfootImage [] img)// cria a animaçao 
    {
        indice++;
        
        if (indice >= img.length )
        {
            indice = 0;
        }

        setImage(img[indice]);
    }
    
    public void animacao(int personagem){ //animaçaoo para cada personagem
        int img = 1;
        
        for(int i = 1; i<=3; i++){// personagem 1
            imagensF[i-1] = new GreenfootImage("P"+personagem+" "+img+".png");
            img++;
        }
        for(int i = 1; i<=3; i++){//personagem 2
            imagensE[i-1] = new GreenfootImage("P"+personagem+" "+img+".png");
            img++;
        }
        for(int i = 1; i<=3; i++){//personagem 3
            imagensD[i-1] = new GreenfootImage("P"+personagem+" "+img+".png");
            img++;
        }
        for(int i = 1; i<=3; i++){//personagem 4
            imagensT[i-1] = new GreenfootImage("P"+personagem+" "+img+".png");
            img++;
        }
    }
    
    public void checkKeyPress(int P) //movimento
    {//acima
        String a = new String();
        String b = new String();
        String c = new String();
        String d = new String();
        if(P == 1){//teclas para o primer player
            a = "W";
            b = "S";
            c = "A";
            d = "D";
        }
        else{//teclas para o segundo player
            a = "up";
            b = "down";
            c = "left";
            d = "right";
        }
        //cima
        if (Greenfoot.isKeyDown(a)) 
        {
            setLocation(getX(), getY()-2);
            anima(imagensT);
            if (hitMuroLB())//nao avançar se bate
            setLocation(getX(), getY()+2);
        }
        //baixo
        if (Greenfoot.isKeyDown(b)) 
        {
            setLocation(getX(), getY()+2);
            anima(imagensF);
            if (hitMuroLB())//nao avançar se bate
            setLocation(getX(), getY()-2);
                }
        //esquerda
        if(Greenfoot.isKeyDown(c)){
            setLocation(getX() -2, getY());
            anima(imagensE);
            if (hitMuroLB())//nao avançar se bate
            setLocation(getX()+2, getY());
        }
        //direita
        if(Greenfoot.isKeyDown(d)){
            setLocation(getX() +2, getY());
            anima(imagensD);
            if (hitMuroLB())//nao avançar se bate
            setLocation(getX()-2, getY());
                }
    }
    
    public void correr(int P){
        String a = new String();
        String b = new String();
        String c = new String();
        String d = new String();
        String e = new String();
        if(P == 1){
            a = "W";
            b = "S";
            c = "A";
            d = "D";
            e = "shift";
        }
        else{
            a = "up";
            b = "down";
            c = "left";
            d = "right";
            e = "control";
        }
        //correr rapido
        //direita 
        if(Greenfoot.isKeyDown(d) && Greenfoot.isKeyDown(e) && stamina>0){
            setLocation(getX() +3, getY());
            anima(imagensD);
            stamina--;
            if (hitMuroLB())
            setLocation(getX()-3, getY());
        }
        //acima
        if (Greenfoot.isKeyDown(a) && Greenfoot.isKeyDown(e) && stamina>0) {
            setLocation(getX(), getY()-3);
            anima(imagensT); 
            stamina--;
            if (hitMuroLB())
            setLocation(getX(), getY()+3);
        }
        //baixo
        if (Greenfoot.isKeyDown(b) && Greenfoot.isKeyDown(e) && stamina>0) {
            setLocation(getX(), getY()+3);
            anima(imagensF);
            stamina--;
            if (hitMuroLB())
            setLocation(getX(), getY()-3);
                }
        //esquerda
        if(Greenfoot.isKeyDown(c) && Greenfoot.isKeyDown(e) && stamina>0){
            setLocation(getX() -3, getY());
            anima(imagensE);
            stamina--;
            if (hitMuroLB())
            setLocation(getX()+3, getY());
        }  
    }
    
    
public void playerHit(int player){
    if (nivel==1){
        if (hitEnemy()&& player==1){//se bate ao player 1
            setLocation(65,85);//volta para a posiçao
            playerLives--;//perde vida
            key = 0;//perde a chave
            getWorld().getObjects(Bau.class).get(0).abrir_bau(false);
            if (playerLives==2)
                getWorld().getObjects(Vida.class).get(0).perdeVida(2);
            if (playerLives==1)
                getWorld().getObjects(Vida.class).get(0).perdeVida(1);
            if (playerLives==0){
                getWorld().getObjects(Vida.class).get(0).perdeVida(0);
                if(nivel == 1){
                    Greenfoot.setWorld(new GameOver(1));
                }
                else  if (nivel == 2){
                    Greenfoot.setWorld(new GameOver(2));
                }
            }
            getWorldOfType(Labirinto.class).somaPontos(-100);
        }      
        if (hitEnemy()&& player==2){
            setLocation(832,816);// volta para a posiçao 
            playerLives--;//perde vida
            key=0;//perde chave
            getWorld().getObjects(Bau.class).get(0).abrir_bau(false);
            if (playerLives==2)
                getWorld().getObjects(Vida.class).get(1).perdeVida(2);
            if (playerLives==1)
                getWorld().getObjects(Vida.class).get(1).perdeVida(1);
            if (playerLives==0){
                getWorld().getObjects(Vida.class).get(1).perdeVida(0);
                if(nivel == 1){
                    Greenfoot.setWorld(new GameOver(1));// se morre aparece game over
                }
                else  if (nivel == 2){
                    Greenfoot.setWorld(new GameOver(2));// se morre no segundo nivel game over do segundo nivel
                }
            }
            getWorldOfType(Labirinto.class).somaPontos(-100);//perde pontos
        }
    }
    if (nivel==2){   // todo igual mas para o segundo nivel
        if (hitEnemy()&& player==1){
            setLocation(65,85);
            playerLives--;
            if (playerLives==2)
            getWorld().getObjects(Vida.class).get(0).perdeVida(2);
            if (playerLives==1)
                getWorld().getObjects(Vida.class).get(0).perdeVida(1);
            if (playerLives==0){
                getWorld().getObjects(Vida.class).get(0).perdeVida(0);
                if(nivel == 1){
                    Greenfoot.setWorld(new GameOver(1));
                }
                else  if (nivel == 2){
                    Greenfoot.setWorld(new GameOver(2));
                }
            }
            getWorldOfType(CamaraGas.class).somaPontos(-100);
        }      
        if (hitEnemy()&& player==2){
            setLocation(130,85);
            playerLives--;
        
            if (playerLives==2)
                getWorld().getObjects(Vida.class).get(1).perdeVida(2);
            if (playerLives==1)
                getWorld().getObjects(Vida.class).get(1).perdeVida(1);
            if (playerLives==0){
                getWorld().getObjects(Vida.class).get(1).perdeVida(0);
                if(nivel == 1){
                    Greenfoot.setWorld(new GameOver(1));
                }
                else if (nivel == 2){
                    Greenfoot.setWorld(new GameOver(2));
                }
            }
            getWorldOfType(CamaraGas.class).somaPontos(-100);
        }
    }
}

    public int getPlayer(){ //retorna player
        return player;
    }
    
    public void ativaLever(int player){
        if(nivel == 1){//verifica o nivel
        if(player == 1){
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaVermelha.class).get(0))){//
                if(tocouLeverV == false && status == 0){//tocou o lever e o status é 0
                    getWorld().getObjects(AlavancaVermelha.class).get(0).puxarLever(true);//lever para direita
                    getWorld().getObjects(Barreiras.class).get(0).abrirBarreira(true);//abre a barreira
                    status = 1;//status passa a 1
                }
                else if (tocouLeverV == false && status == 1){
                    getWorld().getObjects(AlavancaVermelha.class).get(0).puxarLever(false);//lever passa esquerda
                    getWorld().getObjects(Barreiras.class).get(0).abrirBarreira(false);//fecha a barreira
                    status = 0;
                }
                tocouLeverV=true;
            }
            else{
            tocouLeverV=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaAzul.class).get(0))){
                if(tocouLeverA == false && status == 0){
                    getWorld().getObjects(AlavancaAzul.class).get(0).puxarLever(true);
                    getWorld().getObjects(Barreiras.class).get(1).abrirBarreira(true);
                    status = 1;
                }
                else if (tocouLeverA == false && status == 1){
                    getWorld().getObjects(AlavancaAzul.class).get(0).puxarLever(false);
                    getWorld().getObjects(Barreiras.class).get(1).abrirBarreira(false);
                    status = 0;
                }
                tocouLeverA=true;
            }
            else{
            tocouLeverA=false;
            }
        }
        if(player == 2){
            if(Greenfoot.isKeyDown("0") && intersects(getWorld().getObjects(AlavancaVermelha.class).get(0))){
                if(tocouLeverV == false && status == 0){
                    getWorld().getObjects(AlavancaVermelha.class).get(0).puxarLever(true);
                    getWorld().getObjects(Barreiras.class).get(0).abrirBarreira(true);
                    status = 1;
                }
                else if (tocouLeverV == false && status == 1){
                    getWorld().getObjects(AlavancaVermelha.class).get(0).puxarLever(false);
                    getWorld().getObjects(Barreiras.class).get(0).abrirBarreira(false);
                    status = 0;
                }
                tocouLeverV=true;
            }
            else{
            tocouLeverV=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorld().getObjects(AlavancaAzul.class).get(0))){
                if(tocouLeverA == false && status == 0){
                    getWorld().getObjects(AlavancaAzul.class).get(0).puxarLever(true);
                    getWorld().getObjects(Barreiras.class).get(1).abrirBarreira(true);
                    status = 1;
                }
                else if (tocouLeverA == false && status == 1){
                    getWorld().getObjects(AlavancaAzul.class).get(0).puxarLever(false);
                    getWorld().getObjects(Barreiras.class).get(1).abrirBarreira(false);
                    status = 0;
                }
                tocouLeverA=true;
            }
            else{
            tocouLeverA=false;
            }
        }
        }
    }
    
    public void abrirBau(int player){
        if(player == 1){
            if(Greenfoot.isKeyDown("E") && isTouching(Bau.class)){ 
                if(tocoubau == false && statusBau == 0){//abre o bau
                    getWorld().getObjects(Bau.class).get(0).abrir_bau(true);
                    statusBau = 1;
                if (key==0){//adiciona a chave se nao tem
                    getWorld().addObject(new Key(),345,840);
                }
                }
                else if (tocoubau == false && statusBau == 1){//fecha o bau
                getWorld().getObjects(Bau.class).get(0).abrir_bau(false);
                statusBau = 0;
                }
                tocoubau=true;
            }
            else{
            tocoubau=false;
            }
        }
         
        if(player == 2){// o mesmo mas para o segundo jogador
          if(Greenfoot.isKeyDown("0") && isTouching(Bau.class)){
                if(tocoubau == false && statusBau == 0){
                    getWorld().getObjects(Bau.class).get(0).abrir_bau(true);
                    statusBau = 1;
                    if (key==0){
                    getWorld().addObject(new Key(),345,840);
                    }
                }
                else if (tocoubau == false && statusBau == 1){
                    getWorld().getObjects(Bau.class).get(0).abrir_bau(false);
                    statusBau = 0;
                }
                tocoubau=true;
            }
            else{
            tocoubau=false;
            }
        }
    }
    
    public void removeKey()//pega a chave
    {
        if (isTouching(Key.class))
        {
            removeTouching(Key.class);
            getWorldOfType(Labirinto.class).somaPontos(100);
            Greenfoot.playSound("SomKey.mp3");
            key = 1;
        }
    }
    
    public int getKey(){//retorna key
        return key;
    }
    
     public void abrirQuadro(int player){
        if(player == 1){
        if(Greenfoot.isKeyDown("E") && isTouching(BotaoLaranja.class)){
                if(tocouquadroL == false && status_quadro == 0){// tocou o botao e estatus 0
                    getWorld().addObject(new Quadro("pergunta1.png",2),450,800);//adiciona a pergunta
                    Greenfoot.playSound("SomBotao.mp3");//som
                    status_quadro = 1;//status passa 1
                }
                else if (tocouquadroL == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroL=true;
            }
        else{
            tocouquadroL=false;
            }
           
        if(Greenfoot.isKeyDown("E") && isTouching(BotaoCastanho.class)){
                if(tocouquadroC == false && status_quadro == 0){
                    getWorld().addObject(new Quadro("pergunta2.png",2),450,800);
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro = 1;
                }
                else if (tocouquadroC == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroC=true;
            }
            else{
            tocouquadroC=false;
            }    
        if(Greenfoot.isKeyDown("E") && isTouching(BotaoRoxo.class)){
                if(tocouquadroR == false && status_quadro == 0){
                    getWorld().addObject(new Quadro("pergunta3.png",2),450,800);
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro = 1;
                }
                else if (tocouquadroR == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroR=true;
            }
            else{
            tocouquadroR=false;
            }      

    }
    if(player == 2){
        if(Greenfoot.isKeyDown("0") && isTouching(BotaoLaranja.class)){
                if(tocouquadroL == false && status_quadro == 0){
                    getWorld().addObject(new Quadro("pergunta1.png",2),450,800);
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro = 1;
                }
                else if (tocouquadroL == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroL=true;
            }
            else{
            tocouquadroL=false;
            }  
        if(Greenfoot.isKeyDown("0") && isTouching(BotaoCastanho.class)){
                if(tocouquadroC == false && status_quadro == 0){
                    getWorld().addObject(new Quadro("pergunta2.png",2),450,800);
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro = 1;
                }
                else if (tocouquadroC == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroC=true;
            }
            else{
            tocouquadroC=false;
            }    
        if(Greenfoot.isKeyDown("0") && isTouching(BotaoRoxo.class)){
                if(tocouquadroR == false && status_quadro == 0){
                    getWorld().addObject(new Quadro("pergunta3.png",2),450,800);
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro = 1;
                }
                else if (tocouquadroR == false && status_quadro == 1){
                    getWorld().removeObjects(getWorld().getObjects(Quadro.class));
                    Greenfoot.playSound("SomBotao.mp3");
                    status_quadro= 0;
                }
                tocouquadroR=true;
            }
            else{
            tocouquadroR=false;
            }      
    }
    }

    public void ativaLever2(int player){
        if(nivel == 2){
        if(player == 1){
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaLaranja.class).get(0))){
                if(tocouLeverL1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L1",true);
                }
                else if (tocouLeverL1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L1",false);
                }
                tocouLeverL1=true;
            }
            else{
            tocouLeverL1=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaLaranja.class).get(1))){
                if(tocouLeverL2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L2",false);
                }
                else if (tocouLeverL2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L2",true);
                }
                tocouLeverL2=true;
            }
            else{
            tocouLeverL2=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaLaranja.class).get(2))){
                if(tocouLeverL3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L3",true);
                }
                else if (tocouLeverL3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L3",false);
                }
                tocouLeverL3=true;
            }
            else{
            tocouLeverL3=false;
            }
            
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaCastanha.class).get(0))){
                if(tocouLeverC1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C1",true);
                }
                else if (tocouLeverC1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C1",false);
                }
                tocouLeverC1=true;
            }
            else{
            tocouLeverC1=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaCastanha.class).get(1))){
                if(tocouLeverC2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C2",true);
                }
                else if (tocouLeverC2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C2",false);
                }
                tocouLeverC2=true;
            }
            else{
            tocouLeverC2=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaCastanha.class).get(2))){
                if(tocouLeverC3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C3",true);
                }
                else if (tocouLeverC3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C3",false);
                }
                tocouLeverC3=true;
            }
            else{
            tocouLeverC3=false;
            }
            
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaRoxa.class).get(0))){
                if(tocouLeverR1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R1",false);
                }
                else if (tocouLeverR1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R1",true);
                }
                tocouLeverR1=true;
            }
            else{
            tocouLeverR1=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaRoxa.class).get(1))){
                if(tocouLeverR2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R2",true);
                }
                else if (tocouLeverR2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R2",false);
                }
                tocouLeverR2=true;
            }
            else{
            tocouLeverR2=false;
            }
            if(Greenfoot.isKeyDown("E") && intersects(getWorld().getObjects(AlavancaRoxa.class).get(2))){
                if(tocouLeverR3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R3",true);
                }
                else if (tocouLeverR3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R3",false);
                }
                tocouLeverR3=true;
            }
            else{
            tocouLeverR3=false;
            }
        }
    
        if(player == 2){
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaLaranja.class).get(0))){
                if(tocouLeverL1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L1",true);
                }
                else if (tocouLeverL1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L1",false);
                }
                tocouLeverL1=true;
            }
            else{
            tocouLeverL1=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaLaranja.class).get(1))){
                if(tocouLeverL2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L2",false);
                }
                else if (tocouLeverL2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L2",true);
                }
                tocouLeverL2=true;
            }
            else{
            tocouLeverL2=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaLaranja.class).get(2))){
                if(tocouLeverL3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaLaranja.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L3",true);
                }
                else if (tocouLeverL3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaLaranja.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("L3",false);
                }
                tocouLeverL3=true;
            }
            else{
            tocouLeverL3=false;
            }
            
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaCastanha.class).get(0))){
                if(tocouLeverC1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C1",true);
                }
                else if (tocouLeverC1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C1",false);
                }
                tocouLeverC1=true;
            }
            else{
            tocouLeverC1=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaCastanha.class).get(1))){
                if(tocouLeverC2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C2",true);
                }
                else if (tocouLeverC2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C2",false);
                }
                tocouLeverC2=true;
            }
            else{
            tocouLeverC2=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaCastanha.class).get(2))){
                if(tocouLeverC3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaCastanha.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C3",true);
                }
                else if (tocouLeverC3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaCastanha.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("C3",false);
                }
                tocouLeverC3=true;
            }
            else{
            tocouLeverC3=false;
            }
            
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaRoxa.class).get(0))){
                if(tocouLeverR1 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(0).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R1",false);
                }
                else if (tocouLeverR1 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(0).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R1",true);
                }
                tocouLeverR1=true;
            }
            else{
            tocouLeverR1=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaRoxa.class).get(1))){
                if(tocouLeverR2 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(1).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R2",true);
                }
                else if (tocouLeverR2 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(1).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R2",false);
                }
                tocouLeverR2=true;
            }
            else{
            tocouLeverR2=false;
            }
            if(Greenfoot.isKeyDown("0") && intersects(getWorldOfType(CamaraGas.class).getObjects(AlavancaRoxa.class).get(2))){
                if(tocouLeverR3 == false && status2 == 0){
                    getWorld().getObjects(AlavancaRoxa.class).get(2).puxarLever(true);
                    status2 = 1;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R3",true);
                }
                else if (tocouLeverR3 == false && status2 == 1){
                    getWorld().getObjects(AlavancaRoxa.class).get(2).puxarLever(false);
                    status2 = 0;
                    getWorld().getObjects(Porta.class).get(0).setResposta("R3",false);
                }
                tocouLeverR3=true;
            }
            else{
            tocouLeverR3=false;
            }
        }
        }
    }
    
    public boolean parado(){//verifica se o player esta parado
        if(Greenfoot.getKey()==null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getStamina(){//return stamina
        return stamina;
    }
    
    public void setStamina(int s){
        stamina = s;
    }
    
    public int mundo(){//verifica em que mundo esta o player
        if(this.getWorld().getClass() ==  Labirinto.class){
            nivel = 1;
        }
        else if(this.getWorld().getClass() ==  CamaraGas.class){
            nivel = 2;
        }
        else if(this.getWorld().getClass() ==  Victory.class){
            nivel = 3;
        }
        return nivel;
    }
    
    public int getMundo(){//retorna o nivel
        return nivel;
    }
}










