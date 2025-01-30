public class Ataque {
    int id, dano;
    String tipo;

    public Ataque(int id, int dano, String tipo) {
        this.id = id;
        this.dano = dano;
        this.tipo = tipo;
    }

    public int calcularDanoInimigo(Inimigo inimigo) {

        return this.dano;
    }

    public int calcularDanoPersonagem(Personagem personagem) {
        if (this.tipo.equals("fisico")) {
            return this.dano * personagem.forca;
        } else if (this.tipo.equals("magico")) {
            return this.dano * personagem.inteligencia;
        }
        return 0;
    }
}
