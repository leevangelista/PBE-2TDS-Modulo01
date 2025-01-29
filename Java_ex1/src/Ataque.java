public class Ataque extends Personagem {

    int id, dano;
    String tipo;

    // Definir método construtor
    public Ataque(int id, int dano, String tipo, String nome, int forca, int inteligencia) {
        super(nome, forca, inteligencia);  // Adicionando 'nome' no super()
        this.id = id;
        this.dano = dano;
        this.tipo = tipo;
    }

    public void calcularDanoPersonagem() {
        if (tipo)
    }

}
