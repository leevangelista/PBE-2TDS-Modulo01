import java.util.ArrayList;

public class Emprestimo {
   //Atributos
   int id;
   String data_devolucao;
   Cliente cliente;
   Livro livro;

   int quantidade; // Para armazenar a quantidade

   //Contrutor
    public Emprestimo (int id, String data_devolucao, Cliente cliente, Livro livro) {
        this.id = id;
        this.data_devolucao = data_devolucao;
        this.cliente = cliente;
        this.livro = livro;
    }

    //Metodos
    public void adicionar_livro(Livro livro, int quantidade) {
        this.livro = livro;
        livro.reduzir_estoque(quantidade);
        this.quantidade += quantidade;
    }

    public int calcular_total() {
        return quantidade;
    }

    public void finalizar_emprestimo(Emprestimo emprestimo) {
        System.out.println("Data de devolução " + emprestimo.data_devolucao);
        emprestimo.livro.exibir_detalhes(emprestimo.livro);
    }



}
