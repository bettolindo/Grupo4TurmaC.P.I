package RPG;

public abstract class personagem {

    //caracateristicas do personagem do jogador
    public String nome;
    public int vida , maxVida, xp;

    public personagem(String nome, int maxVida, int xp) {

        this.nome = nome;
        this.vida = vida;
        this.maxVida = maxVida;
        this.xp = xp;
        vida = 10;
    }

    public abstract int ataque();
    public abstract int defesa();
    public abstract int magica();


    
}
