public class Personagem extends Inimigo {
    // Atributos
    int id, inteligencia;
    String nome;

    // Construtor
    public Personagem(String nome, int id, int hp, int forca, int inteligencia) {
        super(hp, forca);
        this.nome = nome;
        this.id = id;
        this.inteligencia = inteligencia;
    }

    // Métodos
    public void atacar(Inimigo inimigo) {
        int dano = this.forca;
        inimigo.receberDano(dano);
        System.out.println(this.nome + " atacou " + inimigo.getNome() + " e causou " + dano + " de dano.");
    }

    @Override
    public void receberDano(int dano) {
        this.hp =- dano;
    }
}
