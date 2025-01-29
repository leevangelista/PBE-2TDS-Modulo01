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

    public void calcularDanoPersonagem(int forca) {
        if (tipo == fisico) {
            calcularDanoPersonagem = dano * forca;
        }else{
            calcularDanoPersonagem = dano * mp;
            }

        }

    public void calcularDanoInimigo(inimigo){

    }
}
