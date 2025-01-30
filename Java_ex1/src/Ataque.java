public class Ataque {
    private int id;
    private String tipo; // "fisico" ou "magico"
    private int dano;

    public Ataque(int id, String tipo, int dano) {
        this.id = id;
        this.tipo = tipo;
        this.dano = dano;
    }

    public int calcularDanoPersonagem(Personagem personagem) {
        if (this.tipo.equals("fisico")) {
            return this.dano * personagem.getForca();  // Acesso através do getter
        } else if (this.tipo.equals("magico")) {
            return this.dano * personagem.getInteligencia();  // Acesso através do getter
        }
        return 0;
    }

    public int calcularDanoInimigo(Inimigo inimigo) {
        return this.dano + inimigo.getDano();  // Acesso através do getter
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }
}
