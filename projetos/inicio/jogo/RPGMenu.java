package jogo;

import java.util.Scanner;



public class RPGMenu{
    /**
     * @param args
     */
    // menu do jogo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        


        do {
            System.out.println("----- RPG Menu -----");
            System.out.println("1. Criar novo personagem");
            System.out.println("2. Ver personagem existente");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Criando novo personagem...");

                    player();

                    jogo();
                    
                    // Código para criar um novo personagem
                    break;
                case 2:
                    
                    System.out.println("Mostrando personagem existente...");
                    
                    
                    
                    // Código para mostrar informações do personagem existente
                    break;
                case 3:
                    System.out.println("Saindo do RPG...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 3);

        

    }
    //criação e armazenamento do personagem

    public static void player() { Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("olá "+nome);
        int raca;
        
        do{
            System.out.println("qual raça de personagem você deseja escolher: ");
            System.out.println("------------------------------------------------------------------");
            System.out.println("N                                                                N");
            System.out.println("N                1-HUMANO  2-ELFO  3-ANÃO  4-GATINO              N");
            System.out.println("N FORÇA             10       10      12       8                  N");
            System.out.println("N DEESTREZA         10       12      10       12                 N");
            System.out.println("N AGILIDADE         10       10      8        12                 N");
            System.out.println("N INTELIGENCIA      10       12      8        12                 N");
            System.out.println("N CARISMA           10       8       8        8                  N");
            System.out.println("N VIDA              10       12      12       8                  N");
            System.out.println("N                                                                N");
            System.out.println("------------------------------------------------------------------");
            raca = sc.nextInt();

            if (raca == 1){
                System.out.println("Humano ");
                System.out.println("Status: ");
                int força = 10;
                int deestreza = 10;
                int agilidade = 10;
                int inteligência = 10;
                int carisma = 10;
                int vida = 1;

                break;
            }
            if (raca == 2){
                System.out.println("Elfo");
                System.out.println("Status: ");
                int força = 10;
                int deestreza = 12;
                int agilidade = 10;
                int inteligência = 12;
                int carisma = 18;
                int vida = 12;
                break;
            }
            if (raca == 3){
                System.out.println("Anão");
                System.out.println("Status: ");
                int força = 12;
                int deestreza = 10;
                int agilidade = 10;
                int inteligência = 8;
                int carisma = 8;
                int vida = 12;
                break;
            }
            if (raca == 4){
                System.out.println("Gatino");
                System.out.println("Status: ");
                int força = 8;
                int deestreza = 12;
                int agilidade = 12;
                int inteligência = 12;
                int carisma = 8;
                int vida = 8;
                break;
            }
            System.out.println("Opção inválida");
            sc.nextLine();

        }
        while (raca!= 1 && raca!= 2 && raca!= 3 && raca!= 4);

    }
    
    
    public static void jogo(){
    
        System.out.println();
        
        
    }
}

