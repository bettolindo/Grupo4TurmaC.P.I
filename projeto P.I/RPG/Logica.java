package RPG;
import java.util.Scanner;

import javax.swing.JPopupMenu.Separator;
public class Logica{
    static Scanner scanner = new Scanner(System.in);
    public static boolean rodando;
    // encontros aleatorios
    public static String[]
    encontros = {"Combate","Combate","batalha","descanso", "descanso","loja","loja"};
    //nome dos inimigos
    public static String[]
    inimigos = {"lobo-mal","lobo-mal","batman", "robin", "pherb", "felipe neto","boing","pimpolio-Shake"};
    public static int lugar = 0, movimento = 1;
    public static String[] 
    lugars = {"cofre", "pagode", "aeroporto","clubinho"};
    static Player player;
    //method to get user input from console
    public static int readInt(String prompt,int userChoices){
        int input;
        do{
            System.out.print(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("pressione (1) para interagir! ");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }
    //limpar a tela
    public static void clearConsole(){
        for(int i=0; i< 100; i++)
        System.out.println();
    }
    // fazer linhas separadoras
    public static void printSeparator(int n){
        for(int i=0; i< n; i++)
        System.out.print("-");
        System.out.println();
    }
    //utilizar de titulos 
    public static void printheading(String titulo){
        printSeparator(30);
        System.out.println(titulo);
        printSeparator(30);
    }
    //utilizado para mantar por certo tempo os prints na tela ate o player querer avançar por conta propria
    public static void nadaParaContinuar(){
        System.out.println("digite (1) para continuar... ");
        printSeparator(20);
        scanner.next();
        
    }
    //inicio do jogo
    public static void Jogo(){
        boolean nomeSet = false;
        String nome;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Bem vindo ao RPG: O Cofre");
        printSeparator(30);
        printSeparator(40);
        nadaParaContinuar();
        
        do{
            clearConsole();
            printheading("Digite seu nome: ");
            nome = scanner.next();
            clearConsole();
            printheading("seu nome  ("+ nome +") esta correto? ");
            System.out.println("1 - sim");
            System.out.println("2 - nao");
            int input = readInt("-> ", 2);
            if(input == 1)
                nomeSet = true;
                
        }while(!nomeSet);
        
        player = new Player(nome);
        
        rodando = true;
        instrucao();
        loop();
    }
    // metodo que muda os valores do jogo baseado no xp do player
    public static void checarMovimento(){
        //muda o movimento baseado no xp
        if(player.xp >= 10){
            movimento = 2;
            lugar = 1;
            //o player vai escolher oque ele deseja melhorar de habilidade
            player.escolha();
            
            // valores dos inimigos
            inimigos[0] = "ladrão";
            inimigos[1] = "goblin";
            inimigos[2] = "macaco safado";
            inimigos[3] = "bananão";
            inimigos[4] = "samurai";
            //valores de encontros
            encontros[0] = "batalha";
            encontros[1] = "batalha";
            encontros[2] = "batalha";
            encontros[3] = "descanso";
            encontros[4] = "loja";
            player.vida = player.maxVida;
        }else if(player.xp >= 20 && movimento == 2){
        
            movimento = 3;
            lugar = 2;
            
            // outra melhora de habilidade
            player.escolha();
            
            // valores dos inimigos
            inimigos[0] = "Vampiro";
            inimigos[1] = "jogador 2";
            inimigos[2] = "kenny west";
            inimigos[3] = "bobber";
            inimigos[4] = "otaku";
            //valores de encontros
            encontros[0] = "batalha";
            encontros[1] = "batalha";
            encontros[2] = "batalha";
            encontros[3] = "batalha";
            encontros[4] = "loja";
            player.vida = player.maxVida;
        }else if(player.xp >= 30 && movimento == 3){
            movimento = 4;
            lugar = 3;
            //melhorar habilidades do player
            player.escolha();
            // valores dos inimigos
            inimigos[0] = "Vampiro";
            inimigos[1] = "jogador 2";
            inimigos[2] = "kenny west";
            inimigos[3] = "bobber";
            inimigos[4] = "otaku";
            //valores de encontros
            encontros[0] = "batalha";
            encontros[1] = "batalha";
            encontros[2] = "batalha";
            encontros[3] = "batalha";
            encontros[4] = "loja";
            
            
            
            player.vida = player.maxVida;
            
            
        }
    }
    
    public static void encontroAleatorio(){
        // numeros aleatorios entre 0 e a quantidade de encontros gerados
        int encontro = (int) (Math.random()* encontros.length);
        // chamandos os respectivos metodos
        if(encontros[encontro].equals("batalha")){
            
            batalhaAleatoria();
        }else if(encontros[encontro].equals("restaurador")){
            pegarRest();
        }else{
            if(player.xp >=10){
                loja();
            }else{
                batalhaAleatoria();
            }
        }
        
    }
    public static void continuarJogo(){
        // lê o movimento feito do jogador
        checarMovimento();
        //lê a ação do jogo
        if (movimento != 4)
            encontroAleatorio();
    }
    //informa o status do player
    public static void infoPersonagem(){
        clearConsole();
        printheading("Informações do personagem");
            System.out.println(player.nome + " vida "+ player.vida + "/" + player.maxVida); 
            printSeparator(20);
            System.out.println("XP: "+ player.xp + " Moedas: "+ player.moedas);
            printSeparator(20);
            //numero de garrafas Magicas
            System.out.println("Numero de garrafas Magicas: "+player.garrafas);
            printSeparator(20);
            if(player.numMelhorAtk > 0){
                System.out.println("Melhor atk: "+ player.melhorarAtk[player.numMelhorAtk - 1]);
                printSeparator(20);
            }
            if(player.numMelhorDef > 0){
                System.out.println("Melhor Magia: "+ player.melhorarMagia[player.numMelhorMagia - 1]);
                printSeparator(20);
            }
            nadaParaContinuar();
        }
        //serve para ramdomizar os inimigos de batalha
        public static void batalhaAleatoria(){
            clearConsole();
            printheading("Você encontrou um inimigo " +", agora é tudo ou nada, comece a batalha!");
            nadaParaContinuar();
            //criar novos inimigos com nomes aleatorios
            batalha(new inimigo(inimigos[(int)(Math.random()*inimigos.length)], player.xp)); //
        }
        // loja de compras do jogador
        public static void loja(){
            clearConsole();
            printheading("você encontrou um maluco so de casacão vendendo coisas misteriosas?!");
            printheading("veja oque ele tem a oferecer");
            int preco = (int) (Math.random()* (10 + player.garrafas*3)+10+player.garrafas);
            System.out.println("- garrafa magica "+ preco + " gold");
            printSeparator(20);
            //checar se o player quer comprar uma garrafa magica
            System.out.println("você aceita comprar essa garrafa misteriosamente magica desse estranho quase pelado? ");
            System.out.println("(1) - sim");
            System.out.println("(2) - não");
            int input = readInt("-> ", 2);
            if(input == 1){
                clearConsole();
                //player compra uma garrafa
                if(player.moedas >= preco){
                printheading("você comprou uma garrafa magica por "+ preco+" moedas");
                player.garrafas++;
                player.moedas -= preco;
                }else{
                    //player n tem dinheiro para comprar garrafa
                    printheading("você esta pobre no momento, seu pobre safado!");
                    nadaParaContinuar();
                }
            }else{
                //player nao quer comprar uma garrafa
                printheading("ok, ate a proxima viajante!!");
                nadaParaContinuar();
            }
            // pehando uma rest
        
            
        }
        // serve para utilizar um restaurador de vida
        public static void pegarRest(){
            clearConsole();
            if(player.rest >= 1){
                printheading("você deseja pegar uma rest? ");
                System.out.println("(1) - sim");
                System.out.println("(2) - não");
                int input = readInt("-> ", 2);
                if (input == 1){
                    // o player pega uma rest
                    clearConsole();
                    if(player.vida < player.maxVida){
                        int vidaRestaurada = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                        player.vida += vidaRestaurada;
                        if(player.vida > vidaRestaurada){
                            player.vida = vidaRestaurada;
                            System.out.println("sua vida ta melhor agora " + "\nvida total: "+ player.vida + "/"+player.maxVida);
                            player.rest--;
                        }else
                        System.out.println("sua vida esta totalmente cheia, você não precisa da garrafa magica agora!");
                        nadaParaContinuar();
                        
                    }
                }
            }
        }
        // uma batalha entre player e o inimigo aleatorio
        public static void batalha(inimigo inimigo){
            //batalha loops
            while(true){
                clearConsole();
                printheading(inimigo.nome + " HP: "+ inimigo.vida + "/" + inimigo.maxVida);
                printheading(player.nome + " HP: "+ player.vida + "/" + player.maxVida);
                System.out.println("Escolha um movimento: ");
                printSeparator(20);
                System.out.println("1 - batalha");
                System.out.println("2 - Usar poção");
                System.out.println("3 - fugir");
                int input = readInt("-> ", 3);
                //lê o movimento feito pleo player
                if(input == 1){
                    //batalha
                    printSeparator(20);
                System.out.println("1 - cair na mão");
                System.out.println("2 - Usar poderzinho");
                int input2 = readInt("-> ", 2);
                    if (input2 == 1){
                        //caso o player escolha um ataque fisico
                        int dano = player.ataque() - inimigo.defesa();
                        int danoLevado = player.defesa() - inimigo.ataque();
                    if(danoLevado <= 0){
                        dano -= danoLevado/2;
                        danoLevado = 0;
                    }
                    if(dano <= 0)
                        dano = 0;
                        player.vida -=danoLevado;
                        inimigo.vida -= dano;
                        clearConsole();
                        printheading("batalha");
                        System.out.println("Você deu " + dano +" de dano no "+inimigo.nome);
                        printSeparator(15);
                        System.out.println("O " + inimigo.nome + " deu " + danoLevado + " de dano em você.");
                        nadaParaContinuar();
                        
                        if(player.vida <= 0){
                            playerMorreu();
                            break;
                        }else if(inimigo.vida <= 0){
                            //mostrar que o player ganhou
                            clearConsole();
                            printheading("Você derrotou o raivoso inimigo " + inimigo.nome + "!");
                            //receber o xp do inimigo morto
                            player.xp += inimigo.xp;
                            System.out.println("Você absorveu o xp do inimigo " + inimigo.nome + "!");
                            Boolean addRest = (Math.random()* 5 + 1 <=2.25);
                            int xp = (int) (Math.random() * inimigo.xp);
                            if(addRest){
                                player.rest++;
                                System.out.println("você ganhou uma chance de sobrevivver");
                            }
                            if(xp > 0){
                                player.moedas += xp;
                                System.out.println("voce ganhou "+ xp +" de xp do inimigo "+inimigo.nome +"!");
                            }
                            nadaParaContinuar();
                            break;
                        }
                    }else if(input2 == 2){
                        //caso o player escolha um ataque magico
                        int dano = player.magica() - inimigo.defesa();
                        int danoLevado = player.defesa() - inimigo.ataque();
                        if(danoLevado <= 0){
                            dano -= danoLevado/2;
                            danoLevado = 0;
                        }
                        if(dano <= 0)
                            dano = 0;
                            player.vida -=danoLevado;
                            inimigo.vida -= dano;
                            clearConsole();
                            printheading("batalha");
                            System.out.println("Você deu " + dano +" de dano no "+inimigo.nome);
                            printSeparator(15);
                            System.out.println("O " + inimigo.nome + " deu " + danoLevado + " de dano em você.");
                            nadaParaContinuar();
                            
                            if(player.vida <= 0){
                                playerMorreu();
                                break;
                            }else if(inimigo.vida <= 0){
                                //mostrar que o player ganhou
                                clearConsole();
                                printheading("Você derrotou o raivoso inimigo " + inimigo.nome + "!");
                                //receber o xp do inimigo morto
                                player.xp += inimigo.xp;
                                System.out.println("Você absorveu o xp do inimigo " + inimigo.nome + "!");
                                Boolean addRest = (Math.random()* 5 + 1 <=2.25);
                                int chanceDeOuro = (int) (Math.random() * inimigo.xp);
                                if(addRest){
                                    player.rest++;
                                    System.out.println("você ganhou uma chance de sobrevivver");
                                }
                                if(chanceDeOuro > 0){
                                    player.moedas += chanceDeOuro;
                                    System.out.println("voce ganhou "+ chanceDeOuro +" de xp do inimigo "+inimigo.nome +"!");
                                }
                                nadaParaContinuar();
                                break;
                        }
                    }
                    
                    
                
                
                }
                else if(input == 2){
                    //utilização de poção
                    clearConsole();
                    garrafa();
                    nadaParaContinuar();
                        
                }else if (input == 3){
                    //caso o player tente fugir do inimigo aleatorio
                clearConsole();
                    if(Math.random()*10 + 1 <= 3.5){
                        printheading("você fugio do inimigo "+ inimigo.nome+"\n");
                        nadaParaContinuar();
                            break;
                    }else{
                        printheading("você não conseguiu fugir do inimigo "+ inimigo.nome);
                        int danoRecebido = (inimigo.ataque()/2+3);
                        player.vida -= danoRecebido;
                        System.out.println("você recebeu um dano por tenta fugir do inimigo "+"\ndano recebido "+ danoRecebido);
                        nadaParaContinuar();
                        //checar se o player esta vivo por essa burrice
                        if(player.vida <= 0){
                            playerMorreu();
                            break;
                        }
                    }
                }
                    //fugir
                    
                
            }
        }
        //segundo menu que aparece para o player
        public static void printMenu(){
            clearConsole();
            printheading("Escolha uma opção");
            printSeparator(20);
            System.out.println("Player: "+player.nome);
            printSeparator(20);
            System.out.println("1 - Jogar");
            System.out.println("2 - Info");
            System.out.println("3 - Usar item");
            System.out.println("4 - Instruções");
            System.out.println("5 - Creditos");
            System.out.println("6 - Sair");
            printSeparator(20);
            }
    public static void loop(){
        // loop de escolha do segundo menu que aparece ao player
        while(rodando){
        printMenu();
            int input = readInt("-> ", 6);
            if (input == 1)
                continuarJogo();
            else if (input == 2)
                infoPersonagem();
            else if(input == 3)
                garrafa();
            else if(input == 4)
                instrucao();
            else if(input == 5)
                creditos();
            else if (input == 6){
                
                avaliacao();

                rodando = false;
            }
                
                }
        
    }
    
    
    public static void playerMorreu(){
        //caso o player morra no meio do jogo
        clearConsole();
        printheading("SI FUDEU!");
        printheading("tente novamente, loser!!!");
        printSeparator(20);
        player.vida = player.maxVida/2;
        player.xp = player.xp /3;
        System.out.println(" você esta agora com "+player.vida+"/"+player.maxVida);
        printSeparator(20);
        System.out.println(" você esta agora com "+player.xp+" de xp");
        printSeparator(20);

        nadaParaContinuar();
    }
    //função para utilizar o intem
    public static void garrafa(){
        printheading("você quer usar uma garrafa magica para se curar? ");
                        printheading("você tem apenas "+ player.garrafas);
                        System.out.println("(1) - sim");
                        System.out.println("(2) - talvez mais tarde");
                        int input = readInt("-> ", 2); 
                        if(input == 1){
                            if(player.vida < player.maxVida){
                                player.vida = player.maxVida;
                                    clearConsole();
                                    printheading("Você bebeu uma garrafa magica e agora esta com a vida totalmente cheia: "+player.maxVida+"/"+player.maxVida);
                                    nadaParaContinuar();
                            }else if(player.vida == player.maxVida){
                                System.out.println("sua vida ja esta totalmente cheia: "+player.maxVida+"/"+player.maxVida);
                                nadaParaContinuar();
                            }else if(player.garrafas < 1){
                                System.out.println("você nao tem garrafas magicas no momento");
                                nadaParaContinuar();
                            }
                        }else{
                        printheading("ok, tente novamente mais tarde :) ");
                        nadaParaContinuar();
                        }
    }
    public static void instrucao(){
        //instruções basicas do jogo
        clearConsole();
        printSeparator(40);
        printSeparator(20);
        printheading("Instruções");
        printSeparator(20);
        System.out.println("este jogo é um rpg textual basico de combate, criado baseado em varios jogos como: ");
        System.out.println("pokemon, zelda, demons bob...\n");
        System.out.println("você tem escolhas para batalhar, escolhe item");
        System.out.println("ver os status do seu personagem e fugir batalhas se estiver com medo de morrer!!");
        System.out.println("basta digitar um dos numeros que aparecem ao lado das opções\n ");
        System.out.println("Agora, como eu acho que você entendeu, é hora de jogar");
        System.out.println("Bora la seu noob!!!");
        printSeparator(40);
        nadaParaContinuar();
    }
    public static void creditos(){
        //os creditos do jogo
        clearConsole();
        printSeparator(20);
        printheading("criadores do rpg");
        printSeparator(20);
        printheading("Roberto belchior junior");
        printheading("Richard Miranda São Bernado");
        printheading("Miguel Oliveira Bezerra");
        printheading("Vinicius de Paula");
        printSeparator(20);
        nadaParaContinuar();
    }
    public static void avaliacao(){
        
        clearConsole();
        printSeparator(20);
        System.out.println("Avaliação do jogo");
        printSeparator(20);
        System.out.println("de 1 a 5 oque você achou do jogo? ");
        System.out.println("(1) - achei uma bosta aceitavel");
        System.out.println("(2) - o jogo esta aceitavel");
        System.out.println("(3) - o jogo esta daorinha");
        System.out.println("(4) - o jogo é muito legal");
        System.out.println("(5) - o jogo esta do caralho");
        int input3 = readInt("->", 5);
        
        if(input3 == 1){
            clearConsole();
            printSeparator(20);
            System.out.println("você que é a bosta aqui");
            System.out.println("ate a proxima, "+player.nome);
            printSeparator(20);
            nadaParaContinuar();
            rodando = false;
        }else{
            clearConsole();
            printSeparator(20);
            System.out.println("obrigado pela avaliação e por jogar nosso jogo!!!");
            System.out.println("ate a proxima, "+player.nome);
            printSeparator(20);
            nadaParaContinuar();
            rodando = false;
        }
    }
    
    
}