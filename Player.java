package RPG;

public class Player extends caracteristicas {

    public int numMelhorAtk, numMelhorDef, numMelhorMagia;
    public int habilidade;

    //incrementar os status de inventarios
    int moedas, garrafas, rest;
    public String[] melhorarMagia = {"Abracadabra", "alakasam","Avdaquedabra","kamehameha","haduken"};
    public String[] melhorarAtk = {"murro", "poder", "super sayajin","one-punch","destruidor de pessoas"};
    public String[] melhorarDef = {"ossos de aço", "pele de pedra", "Armadura dos deuses","invencivel"};

    public Player(String nome) {
        super(nome, 100, 0);
        
        this.numMelhorAtk = 1;
        this.numMelhorDef = 1;
        this.numMelhorMagia = 1;

        //status de inventarios
        this.moedas = moedas + nivel;
        this.garrafas = 1;
        this.rest = 0;

        
    }
    
    
    @Override
    public int ataque() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(nivel/4+numMelhorAtk*2+3)+nivel/10+numMelhorAtk*2+numMelhorDef+2);  
    }
    @Override
    public int defesa() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(nivel/4+numMelhorDef*2+3)+nivel/10+numMelhorDef*2+numMelhorAtk+2);
    }
    @Override
    public int magica() {
        //TODO Auto-generated method stub
        return (int) (Math.random()*(nivel/4+numMelhorMagia*2+3)+nivel/10+numMelhorMagia*2+numMelhorAtk+2);
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
