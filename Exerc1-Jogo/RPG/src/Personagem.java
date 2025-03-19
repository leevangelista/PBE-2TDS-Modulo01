public class Personagem {
    private int id;
    private String nome;
    private int hp;
    private int forca;
    private int inteligencia;
//    private int dano;
//    ptivate int ataque;


    public Personagem(int id, String nome, int hp, int forca, int inteligencia) {
        this.id = id;
        this.nome = nome;
        this.hp = hp;
        this.forca = forca;
        this.inteligencia = inteligencia;
    }

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


    public int receberDano(int danoInimigo) {
        setHp(hp - danoInimigo);
        return getHp();
    }

    public int atacar(int hpInimigo, int ataque) {
        hpInimigo = hpInimigo - ataque;
        return hpInimigo;
    }

    public void info(int id, String  nome, int hp, int forca, int inteligencia){
        System.out.println("Id: "+id);
        System.out.println("Nome: "+nome);
        System.out.println("HP: "+hp);
        System.out.println("Força: "+forca);
        System.out.println("Inteligência: "+inteligencia);
    }

}
