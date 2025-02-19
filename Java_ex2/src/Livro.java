public class Livro {
    // Atributos
    int id;
    String nome;
    float preco;
    int quantidade_estoque;

    //contrutor
    public Livro (int id, String nome, float preco, int quantidade_estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
    }

    //metodos
    public int reduzir_estoque(int quantidade) {
        return this.quantidade_estoque -= quantidade;
    }

    public void exibir_detalhes(Livro livro) {
        System.out.println("id: " + livro.id + "\nnome: " + livro.nome + "\npreço: " + livro.preco + "\nquantidade: " + livro.quantidade_estoque);
    }
}
