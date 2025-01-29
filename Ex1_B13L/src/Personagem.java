public class Personagem {

   private int id;
   private String nome;
   private float hp;
   private int forca;
   private int inteligencia;

   Personagem (){
   }
   Personagem (int id, String nome, float hp, int forca, int inteligencia){
       this.id = id;
       this.forca = forca;
       this.hp = hp;
       this.inteligencia = inteligencia;
   }

   public String getNome () {
        return nome;
   }
   public void setNome (String nome) {
       this.nome = nome;
   }
   public int getId () {
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public float getHp () {
        return hp;
    }
    public void setHp (float hp) {
        this.hp = hp;
    }
    public int getForca () {
        return forca;
    }
    public void setForca (int forca) {
        this.forca = forca;
    }
    public int getInteligencia () {
        return inteligencia;
    }
    public void setNome (int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void receberDano (int dano) {
       this.hp = hp - dano;
       system.out.println("O personagem está com " +hp+ " pontos de HP" );
    }
    public void atacar (Inimigo, Ataque) {

    }


}
