public class Personagem {
    private int id;
    private string nome;
    private int hp;
    private int forca;
    private int inteligencia;
    private int dano;
    ptivate int ataque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getNome() {
        return nome;
    }

    public void setNome(string nome) {
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

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public void receberDano(int dano) {
        if (dano > 0) {
            this.vida -= dano;
            if (this.hp < 0) {
                this.hp = 0;
            }
            System.out.println("O personagem recebeu " + dano + " de dano.");
        } else {
            System.out.println("O dano não pode ser menor ou igual a zero.");
        }
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    public void ataque(int ataque) {
        if (ataque > 0) {
            this.ataque = forca;
            if (this.ataque > 0) {
                this.ataque = 10;
            }
            System.out.println("O personagem deu " + ataque + "de dano";);
        }else  {
            System.out.println("O ataque não pode ser menor que 10");
        }
    }

}
