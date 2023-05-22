public class Player extends Character{
    public int numAtkupgrades, numDefUpgrade;

    public String[] atkUpgrades = {"Força", "Poder", "energia", "força divina"};
    public String[] defUpgrades = {"defesa", "Pele de pedra", "Armadura de Escamas ", "Aura Sagrada"};

    public Player(String nome){
        super(nome, 100, 0);

        this.numAtkupgrades = 0;
        this.numDefUpgrade = 0;
        chooseTrait();

    }
    public int ataque(){
        return 0;
    }
    public int defesa(){
            return 0;
        }
        public void chooseTrait(){
           Gamelogic.clearConsole();
           Gamelogic.printHeading("escolha uma característica: ");
           System.out.println("(1)"+ atkUpgrades[numAtkupgrades]);
           System.out.println("(2)"+ defUpgrades[numDefUpgrade]);
           int input = Gamelogic.readInt("-> ", 2);
           Gamelogic.clearConsole();
           if(input == 1){
              Gamelogic.printHeading("Você escolheu "+atkUpgrades[numAtkupgrades] +"!");
              numAtkupgrades++;

           }else{
            
               Gamelogic.printHeading("Você escolheu "+defUpgrades[numDefUpgrade] +"!");
               numDefUpgrade++;
           }
           Gamelogic.anythingToContinue();

        }
        

    
}
