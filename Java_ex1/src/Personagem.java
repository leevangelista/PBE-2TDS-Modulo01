public class Personagem {
    private int id;
    private String nome;
    private int hp;
    private int forca;
    private int inteligencia;

    // Construtor
    public Personagem(int id, String nome, int hp, int forca, int inteligencia) {
        this.id = id;
        this.nome = nome;
        this.hp = hp;
        this.forca = forca;
        this.inteligencia = inteligencia;
    }

    public void atacar(Inimigo inimigo, Ataque ataque) {
        // "this" é uma referência à própria instância do objeto.
        int dano = ataque.calcularDanoPersonagem(this);
        System.out.println(this.nome + " ataca " + inimigo.getNome() + " com ataque " + ataque.getTipo() + ", causando " + dano + " de dano.");
        inimigo.receberDano(dano);
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

    public int getForca() {
        return forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }
}
