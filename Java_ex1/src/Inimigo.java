public class Inimigo {
    //Atributos
    int id;
    String nome;// (nome do inimigo)
    int hp; //(vida total do inimigo)
    int dano; //(dano que o inimigo causa)
    //Métodos
    public Inimigo(int id, String nome, int hp, int dano){
        this.id = id;
        this.nome = nome;
        this.hp = hp;
        this.dano = dano;
    }

    public void atacar(String Personagem,int Ataque){

    } //Reduz a quantidade de vida do personagem com base no dano do ataque(funcão calcularDanoInimigo).
    public void receber_dano(int dano){
        hp -= dano;
        if (hp < 0) {
            hp = 0; // Garante que a vida não fique negativa
        }
        System.out.println(nome + " recebeu " + dano + " de dano! Vida restante: " + hp);
    }// Reduz a vida do inimigo.
}
