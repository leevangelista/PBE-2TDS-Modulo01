package com.example.SitAprendizagem1.Controller;

import com.example.SitAprendizagem1.Banco.EmprestimoBd;
import com.example.SitAprendizagem1.Model.Cliente;
import com.example.SitAprendizagem1.Model.Emprestimo;
import com.example.SitAprendizagem1.Model.Livro;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoController {

    EmprestimoBd repository = new EmprestimoBd();

    public List<Emprestimo> getAll(){
        return repository.findAll();
    }

    public Emprestimo getByDataFim(LocalDate dataFim){
        return repository.getByDataFim(dataFim);
    }

    public boolean insert(Emprestimo emprestimo){
        return repository.insert(emprestimo);
    }

    public boolean insertLivro(Long idEmprestimo, Livro livro){
        Emprestimo emprestimo = repository.getById(idEmprestimo);
        if(emprestimo == null){
            return false;
        }

        repository.insertLivro(emprestimo, livro);
        return true;
    }

    public boolean updateData(Long idEmprestimo, LocalDate dataFim){
        Emprestimo emprestimoBd = repository.getById(idEmprestimo);
        if (emprestimoBd == null){
            return false;
        }

        repository.updateDate(emprestimoBd, dataFim);
        return true;

    }

    public boolean updateCliente(Long idEmprestimo, Cliente cliente) {
        Emprestimo emprestimoBd = repository.getById(idEmprestimo);
        if (emprestimoBd == null) {
            return false;
        }

        repository.updateCliente(emprestimoBd, cliente);
        return true;
    }

    public boolean delete(Long idEmprestimo) {
        Emprestimo emprestimoBd = repository.getById(idEmprestimo);
        if (emprestimoBd == null) {
            return false;
        }

        repository.delete(emprestimoBd);
        return true;
    }
}
