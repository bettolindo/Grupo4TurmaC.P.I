public abstract class Character {

    public String nome;
    public int maxHp, hp, xp;

    public Character(String nome, int maxHp, int xp){
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = hp;
        this.hp = maxHp;
    } 
    
    

    public abstract int ataque();
    public abstract int defesa();
}
