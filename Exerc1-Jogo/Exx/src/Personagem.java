package PACKAGE_NAME;public class Personagem {
        int id ;
        String nome;
        float hp;
        int forca;
        int inteligencia;

        Personagem(int id, String nome, float hp,int forca, int inteligencia){
            this.hp = hp;
            this.nome = nome;
            this.hp = hp;
            this.forca = forca;
            this.inteligencia = inteligencia;
        }

    public void atacar(Inimigo inimigo, Ataque ataque) {
        int dano = ataque.calcularDanoPersonagem(this);
        inimigo.receberDano(dano);
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.hp);
    }

        public float getHp() {
            return hp;
        }

        public void setHp(float hp) {
            this.hp = hp;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getForca() {
            return forca;
        }

        public void setForca(int forca) {
            this.forca = forca;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInteligencia() {
            return inteligencia;
        }

        public void setInteligencia(int inteligencia) {
            this.inteligencia = inteligencia;
        }


    }



