package RPG;

public class inimigo extends personagem{

    int playerXp;
    public inimigo(String nome, int playerXp){
        super(nome, (int) (Math.random()*playerXp + playerXp/3+5), (int)(Math.random()*(playerXp+playerXp/4+2)+1));
        this.playerXp = playerXp;
    }

    // especificações de ataque e defesa calculadas
    @Override
    public int ataque(){
        return (int) (Math.random()* (playerXp/2 + 2) + xp/ 2 + 3);
    }
    
    @Override
    public int defesa(){
        return (int) (Math.random()* (playerXp/2 + 2) + xp/ 2 + 3);
    }
    @Override
    public int magica() {
        // TODO Auto-generated method stub
        return (int) (Math.random()* (playerXp/2 + 2) + xp/ 2 + 3);
    }
    
    
}
