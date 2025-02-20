public class Personagem {
    int id;
    String nome;
    int hp;
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

    public void atacar(Inimigo inimigo, Ataque ataque){
        int dano = ataque.calcularDanoPersonagem(this);
        inimigo.receberDano(dano);
        System.out.println(nome + " ataca " + inimigo.getNome() + " com " + ataque.id + " e causa " + dano + " de dano.");
    }

    public void receberDano(int dano){
        this.hp -= dano;
        if (hp <= 0) {
            System.out.println(nome + " Morreu :(");
        }
        System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + this.hp);
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

    public float getHp() {
        return hp;
    }

    public void setHp(int hp) {
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
