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

    public void atacar(Personagem personagem, Ataque ataque) {
        int dano = ataque.calcularDanoInimigo(this);
        System.out.println(this.nome + " ataca " + personagem.getNome() + " com ataque " + ataque.getTipo() + ", causando " + dano + " de dano.");
        personagem.receberDano(dano);
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. HP restante: " + this.hp);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getDano() {
        return dano;
    }
}
