package RPG;

public class Player extends personagem {

    public int numMelhorAtk, numMelhorDef, numMelhorMagia;
    public int habilidade;

    //incrementar os status de inventarios
    int moedas, garrafas, rest;
    public String[] melhorarMagia = {"Abracadabra", "alakasam","Avdaquedabra"};
    public String[] melhorarAtk = {"força", "poder", "super sayajin"};
    public String[] melhorarDef = {"ossos de aço", "pele de pedra", "Armadura dos deuses"};

    public Player(String nome) {
        super(nome, 100, 0);
        
        this.numMelhorAtk = 1;
        this.numMelhorDef = 1;
        this.numMelhorMagia = 1;

        //status de inventarios
        this.moedas = 5;
        this.garrafas = 1;
        this.rest = 0;

        
    }
    
    
    @Override
    public int ataque() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(xp/4+numMelhorAtk*2+3)+xp/10+numMelhorAtk*2+numMelhorDef+2);  
    }
    @Override
    public int defesa() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(xp/4+numMelhorDef*2+3)+xp/10+numMelhorDef*2+numMelhorAtk+2);
    }
    @Override
    public int magica() {
        //TODO Auto-generated method stub
        return (int) (Math.random()*(xp/4+numMelhorMagia*2+3)+xp/10+numMelhorMagia*2+numMelhorAtk+2);
    }
    public void escolha() {
        Logica.clearConsole();
        Logica.printheading("escolha uma melhora de habilidade habilidade: ");
        System.out.println("(1) - "+ melhorarAtk[numMelhorAtk]);
        System.out.println("(2) - "+ melhorarDef[numMelhorDef]);
        System.out.println("(3) - "+ melhorarMagia[numMelhorMagia]);
        
        int escolha = Logica.readInt("->", 3);
        Logica.clearConsole();
        if(escolha == 1) {
            Logica.printheading("você escolheu "+ melhorarAtk[numMelhorAtk] + "!");
            numMelhorAtk++;
            
        }else if(escolha == 2){
            Logica.printheading("você escolheu "+ melhorarDef[numMelhorDef] + "!");
            numMelhorDef++;
            
        }else if(escolha == 3){
            Logica.printheading("você escolheu "+melhorarMagia[numMelhorMagia]+"!");
            numMelhorMagia++;
            
        }
        Logica.nadaParaContinuar();
    }
    
}
