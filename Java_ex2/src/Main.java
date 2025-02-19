public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro(1, "Harry Potter", 10, 20);
        Livro livro2 = new Livro(2, "Jogos vorazes", 30, 10);

        Cliente cliente1 = new Cliente(1, "Ronald Araujo", "ronaldinhoarau@email.com");

        Emprestimo emprestimo1 = new Emprestimo(1, "11/11/2011", cliente1, livro1);
        emprestimo1.adicionar_livro(livro1, 1);

        emprestimo1.finalizar_emprestimo(emprestimo1);
        emprestimo1.calcular_total();
    }
}