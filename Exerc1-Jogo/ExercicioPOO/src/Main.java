
public class Main {
    public static void main(String[] args) {
        // Criando persoangens
        Personagem harry = new Personagem(1, "Harry", 1000, 10, 200);
        Personagem hobbit = new Personagem(2, "Hobbit", 500, 200, 10);

        // Criando inimigos
        Inimigo oDragao = new Inimigo(1, "O Dragão", 3000, 300);
        Inimigo oGigante = new Inimigo(2, "O Gigante", 5000, 200);

        // Criando ataque
        Ataque ataqueFisico = new Ataque(1, "fisico", 20);
        Ataque ataqueMagico = new Ataque(2, "magico", 50);

        // Simulando batalha
        System.out.println("Simulando a batalha.");

        harry.atacar(oGigante, ataqueMagico);
        hobbit.atacar(oDragao, ataqueFisico);
        oDragao.atacar(hobbit, ataqueFisico);
    }
}