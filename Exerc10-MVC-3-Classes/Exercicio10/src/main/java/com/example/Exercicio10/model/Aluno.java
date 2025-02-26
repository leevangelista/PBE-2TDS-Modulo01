package com.example.Exercicio10.model;

public class Aluno {
    private Long idAluno;
    private String nome;
    private String cpf;

    public Aluno(Long idAluno, String nome, String cpf) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
