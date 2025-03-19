public class Ataque {
    private int id;
    private String tipo;
    private int dano;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int calcularDanoPersonagem(int forca, int inteligencia, String tipo) {
        int calcularTipoDano = 0;
        if (tipo == "fisico") {
            calcularTipoDano = dano * forca;
        } if (tipo == "magico") {
            calcularTipoDano = dano * inteligencia;
        }
        return calcularTipoDano;
    }

    public int calcularDanoInimigo(int danoDoInimigo, int ataque){
        return danoDoInimigo = dano + ataque;
    }

}

