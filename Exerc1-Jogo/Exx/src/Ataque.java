public class Ataque {
    private int id;
    private String tipo; // "fisico" ou "magico"
    private int dano;

    // Construtor para inicializar o ataque
    public Ataque(int id, String tipo, int dano) {
        this.id = id;
        this.tipo = tipo;
        this.dano = dano;
    }

    // Método que calcula o dano causado por um personagem com base no tipo de ataque
    public int calcularDanoPersonagem(Personagem personagem) {
        if (tipo.equals("fisico")) {
            // Se for um ataque físico, o dano é multiplicado pela força do personagem
            return dano * personagem.getForca();
        } else if (tipo.equals("magico")) {
            // Se for um ataque mágico, o dano é multiplicado pela inteligência do personagem
            return dano * personagem.getInteligencia();
        }
        return 0;
    }

    // Método que calcula o dano causado por um inimigo com base no ataque
    public int calcularDanoInimigo(Inimigo inimigo) {
        // O dano do inimigo é somado ao dano base do ataque
        return inimigo.getDano() + this.dano;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}