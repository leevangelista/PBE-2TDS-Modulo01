public class Inimigo {
    int hp;
    int dano;
    String nome;
    int id;

    Inimigo(){
        System.out.println("nasce um novo inimigo");
    }

    Inimigo(int id, String nome, int hp, int dano){
        this.dano = dano;
        this.hp = hp;
        this.nome = nome;
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public float getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }

    public void atacar(Personagem personagem, Ataque ataque) {
        int dano = ataque.calcularDanoInimigo(this);
        personagem.receberDano(dano);
        System.out.println(nome + " ataca " + personagem.getNome() + " com " + ataque.id + " e causa " + dano + " de dano.");
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + this.hp);
    }
}
