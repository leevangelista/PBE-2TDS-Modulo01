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

    public int calcularDanoPersonagem(int forca, int inteligencia) {
        int calcularTipoDano;
        if (tipo == "fisico") {
            calcularTipoDano = dano * forca;
        } else {
            calcularTipoDano = dano * inteligencia;
        }
        return calcularTipoDano;
    }

    public int calcularDanoInimigo(int danoDoInimigo){
        return danoDoInimigo += dano;
    }

}

