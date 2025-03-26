package com.example.SitAprendizagem1.Model;

public class Livro {
    private Long id;
    private String nome;
    private String autor;
    private String genero;

    public Livro(Long id, String nome, String autor, String genero) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
