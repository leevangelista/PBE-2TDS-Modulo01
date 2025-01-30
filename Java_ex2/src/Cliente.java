public class Cliente {
    //Atributos
    private int id;// (identificador do cliente)
    private String nome;// (nome do cliente)
    private String email;// (e-mail para contato)
    //Métodos
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public void exibir_cliente(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
    }
}