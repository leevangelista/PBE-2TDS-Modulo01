import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

//        while(true){

        Personagem p1 = new Personagem(1234,"p1",100,89,20);
        Inimigo i1 = new Inimigo("i1",4321,160,67);
        p1.info(1234,"p1",100,89,20);
        System.out.println();
        i1.info(4321,"i1",160,67);

        Ataque atq = new Ataque();
        int ataP= atq.calcularDanoPersonagem(89,20, "fisico");
        p1.atacar(160,ataP);
        System.out.println("Ataque Personagem: "+ataP);
        i1.receberDano(ataP);
        System.out.println("HP Inimigo: "+i1.getHp());

        System.out.println();

        int ataI = atq.calcularDanoInimigo(67, 100);
        i1.atacar(100,ataI);
        System.out.println("Ataque Inimigo: "+ataI);
        p1.receberDano(ataI);
        System.out.println("HP Personagem: "+p1.getHp());

    }
}