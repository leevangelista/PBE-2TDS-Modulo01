public class Inimigo {

    private int id;
    private String nome;
    private int hp;
    private int dano;

    public Inimigo(String nome, int id, int hp, int dano) {
        this.nome = nome;
        this.id = id;
        this.hp = hp;
        this.dano = dano;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getDano() {
        return dano;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int atacar(int hpPersonagem, int ataque) {
        hpPersonagem = hpPersonagem - ataque;
        return hpPersonagem;
    }

    public int receberDano(int danoPesonagem) {
        return hp - danoPesonagem;
    }
}

