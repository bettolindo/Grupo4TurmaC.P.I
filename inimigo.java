package RPG;

public class inimigo extends caracteristicas{

    int playerNivel;
    public inimigo(String nome, int playerNivel){
        super(nome, (int) (Math.random()*playerNivel + playerNivel/3+5), (int)(Math.random()*(playerNivel+playerNivel/4+2)+1));
        this.playerNivel = playerNivel;
    }

    // especificações de ataque e defesa calculadas
    @Override
    public int ataque(){
        return (int) (Math.random()* (playerNivel/2 + 2) + nivel/ 2 + 3);
    }
    
    @Override
    public int defesa(){
        return (int) (Math.random()* (playerNivel/2 + 2) + nivel/ 2 + 3);
    }
    @Override
    public int magica() {
        // TODO Auto-generated method stub
        return (int) (Math.random()* (playerNivel/2 + 2) + nivel/ 2 + 3);
    }
    
    
}
