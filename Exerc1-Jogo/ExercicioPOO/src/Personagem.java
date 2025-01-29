public class Personagem {
    int id;
    String nome;
    float hp;
    int forca;
    int inteligencia;


    Personagem(){};
    Personagem(int id, String nome, int hp, int forca, int inteligencia){
        this.id = id;
        this.nome = nome;
        this.hp = hp;
        this.forca = forca;
        this.inteligencia = inteligencia;
    };

    void atacar(inim)

    void receber_dano(float hp, float dano, String nome){
        hp = hp - dano;
        if (hp <= 0) {
            System.out.println(nome + " Morreu :(");
        }
    }


    //getset
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }




}
