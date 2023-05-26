package RPG;

public abstract class caracteristicas {

    //caracateristicas do personagem do jogador
    public String nome;
    public int vida , maxVida, nivel, mana, maxMana = 100, stamina, maxStamina = 100;

    public caracteristicas(String nome, int maxVida, int nivel) {

        
        this.nome = nome;
        this.vida = vida;
        this.maxVida = maxVida;
        this.nivel = nivel;
        vida = maxVida;
        mana = maxMana;
        stamina = maxStamina;
    }

    public abstract int ataque();
    public abstract int defesa();
    public abstract int magica();

    


    
}
