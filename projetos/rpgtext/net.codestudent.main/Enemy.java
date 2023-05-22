


public class Enemy extends Character{

    int playerXp;



    public Enemy(String nome, int playerXp, int xp) {
     
        super(nome, (int) (Math.random()*playerXp+ playerXp/3+5), (int)(Math.random()*playerXp+ playerXp/4+2)+1 );
        this.playerXp = playerXp;
    
    }

    public int ataque(){
        return 0;
    }
    public int defesa(){
        return 0;
    }
    
}
