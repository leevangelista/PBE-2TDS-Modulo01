package com.example.SitAprendizagem1.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {

    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private ArrayList<Livro> livros;
    private Cliente cliente;

    public Emprestimo(Long id, LocalDate dataInicio, LocalDate dataFim, ArrayList<Livro> livros, Cliente cliente) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.livros = livros;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
