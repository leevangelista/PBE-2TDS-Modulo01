public class Main {
    public static void main(String[] args) {
        // Criando os personagens
        Personagem harry = new Personagem(1, "Harry", 1000, 10, 200);
        Personagem hobbit = new Personagem(2, "Hobbit", 500, 200, 10);

        // Criando os inimigos
        Inimigo dragao = new Inimigo(1, "O Dragão", 3000, 300);
        Inimigo gigante = new Inimigo(2, "O Gigante", 5000, 200);

        // Criando os ataques
        Ataque ataqueFisico = new Ataque(1, "fisico", 20);
        Ataque ataqueMagico = new Ataque(2, "magico", 50);

        // Simulando a batalha
        System.out.println("Início do combate:\n");

        // Harry ataca o Gigante com ataque mágico
        harry.atacar(gigante, ataqueMagico);

        // Hobbit ataca o Dragão com ataque físico
        hobbit.atacar(dragao, ataqueFisico);

        // O Dragão ataca o Hobbit com ataque físico
        dragao.atacar(hobbit, ataqueFisico);
    }
}
