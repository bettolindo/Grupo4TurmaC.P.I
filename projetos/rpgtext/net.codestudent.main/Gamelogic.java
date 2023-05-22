import java.util.Scanner;
public class Gamelogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean rodando ;

    public static String[] encounters = {"Batalha","Batalha","Batalha", "Descansar", "Descansar"};

    public static String[] enemies = { "ogro", "ogro", "goblin", "goblin","Elemento pedra"};


    public static int place = 0, act =1;
    public static String[] places = {"montanhas eternas", "Telefones Fixos Assombrados", "castelo do mal", "Sala do trono"};


    public static int readInt(String prompt, int userChoices) {
       int input;
       
       do{
        System.out.print(prompt);
           try{
            input =  Integer.parseInt(scanner.next());
           }catch(Exception e){
           input = -1;
           System.out.println("por favor insira um número inteiro");
           }

       }while(input < 1  || input > userChoices);
       return input;
    }
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
        System.out.println();

    }
    public static void printSeparator(int n){
        for (int i = 0; i < n; i++)
        System.out.print("-");
        System.out.println();

    }
    public static void printHeading(String titulo){
        printSeparator(30);
        System.out.println(titulo);
        printSeparator(30);



    }
    public static void anythingToContinue(){
        System.out.println("digite qualquer coisa para continuar...");
        scanner.nextLine();
    }
    public static void startGame(){
        boolean nomeSet;
        String nome;

        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("ERA DO IMPERADOR MAL");
        
        printSeparator(30);
        printSeparator(40);
        System.out.println();

        do{
            clearConsole();
            printHeading("Qual o seu nome?");
            nome = scanner.nextLine();

            printHeading("seu nome é " + nome+ " esta correto?" );
            System.out.println("(1) sim");
            System.out.println("(2) não");
            int input = readInt("->", 2);
            if(input == 1){
                nomeSet = true;
            }else{
                nomeSet = false;
            }

        }while(!nomeSet);

        Story.printIntro();

        

        player = new Player(nome);


        rodando = true;



        gameLoop();

    }
        public static void checarAcao(){
            if(player.xp >= 10 && act ==1 ){
                act = 2;
                place = 1;


                enemies[0] = "Mercenario do mal";
                enemies[1] = "Mercenario do mal";
                enemies[2] = "Capanga do Imperador Maligno";
                enemies[3] = "Capanga do Imperador Maligno";
                enemies[4] = "Capanga do Imperador Maligno";

                encounters[0] = "batalha";
                encounters[1] = "batalha";
                encounters[2] = "batalha";
                encounters[3] = "descansar";
                encounters[4] = "Shop";

                player.hp = player.maxHp;
            }else if(player.xp >= 50 && act ==2 ){
                act = 3;
                place = 2;

                player.xp = player.maxHp;



            }else if(player.xp >= 100 && act ==3){
                act = 4;
                place = 3;

            }

            }
            public static void encontroAleatorio(){
            int encounter =(int) (Math.random()* encounters.length);
            if(encounters[encounter].equals("batalha")){

            }else if(encounters[encounter].equals("descanso")){
            
            }else{

            }



            
            }


    public static void continuarJornada(){
        checarAcao();
            
        if(act != 4)
            encontroAleatorio();
        }

                public static void characterInfo(){
            clearConsole();
            printHeading("Informações");
            System.out.println(player.nome +"HP: " + player.hp+"/"+player.maxHp);
            printSeparator(20);
            System.out.println("XP: "+player.xp);
            printSeparator(20);


            if(player.numAtkupgrades > 0){
                System.out.println("traço ofensivo: " + player.atkUpgrades[player.numAtkupgrades -1]);
                printSeparator(20);
            }
            if(player.numDefUpgrade > 0){
                System.out.println("traço defensivo: " + player.defUpgrades[player.numDefUpgrade -1]);
                


            }
            anythingToContinue();
        }

        public static void printMenu(){
            clearConsole();
            printHeading(places[place]);
            System.out.println("escolha uma ação: ");
            printSeparator(20);
            System.out.println("1. Continuar jornadda");
            System.out.println("2. Informação de jogador");
            System.out.println("3. sair");

        }




    /**
     * 
     */
    public static void gameLoop(){
        while(rodando){
            printMenu();
            int input = readInt("->", 3 );
            if (input == 1)
            continuarJornada();
                else if (input == 2)
                characterInfo();
                else 
                 rodando = false;
        }
            

    }
    
}
