//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Personagem personagem1 = new Personagem(1, Herry, 1000, 10, 200);
        Personagem personagem2 = new Personagem(2, Hobbit, 500, 200, 10);
        Inimigo inimigo1 = new Inimigo(1, Dragao, 3000, 300);
        Inimigo inimigo2 = new Inimigo(2, Gigante, 5000, 200);

        personagem1.Atacar();
        

    }
}