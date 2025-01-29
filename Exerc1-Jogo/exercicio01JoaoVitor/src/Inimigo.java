public class Inimigo {
    private int id;
    private String nome;
    private int hp;
    private int dano;

    public Inimigo(int id, String nome, int hp, int dano) {
        this.id = id;
        this.nome = nome;
        this.hp = hp;
        this.dano = dano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }


    public void atacar(){//instanciar personagem e ataque

    }

    public void receberDano(){

    }


}







