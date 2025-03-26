package com.example.SitAprendizagem1.Banco;

import com.example.SitAprendizagem1.Model.Cliente;
import com.example.SitAprendizagem1.Model.Emprestimo;
import com.example.SitAprendizagem1.Model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoBd {

    public List<Emprestimo> emprestimos;

    public EmprestimoBd(){
        this.emprestimos = new ArrayList<>();
    }

    public List<Emprestimo> findAll(){
        return emprestimos.stream()
                .toList();
    }

    public Emprestimo getById(Long id){
        return emprestimos.stream()
                .filter(emprestimo -> emprestimo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Emprestimo getByDataFim(LocalDate dataFim){
        return emprestimos.stream()
                .filter(emprestimo -> emprestimo.getDataFim().equals(dataFim))
                .findFirst()
                .orElse(null);
    }

    public boolean insert(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
        return true;
    }

    public boolean insertLivro(Emprestimo emprestimo, Livro livro){
        emprestimo.getLivros().add(livro);
        return true;
    }

    public boolean updateDate(Emprestimo emprestimoBd, LocalDate dataFim){
        emprestimoBd.setDataFim(dataFim);
        return true;
    }

    public boolean updateCliente(Emprestimo emprestimo, Cliente cliente){
        emprestimo.setCliente(cliente);
        return true;
    }

    public boolean delete(Emprestimo emprestimo){
        emprestimos.remove(emprestimo);
        return true;
    }
}
