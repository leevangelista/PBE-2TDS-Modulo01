package com.example.Exercicio9.Banco;

import com.example.Exercicio9.Model.Departamento;
import com.example.Exercicio9.Model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBD {
    private List<Departamento> dpts;

    public DepartamentoBD(){
        this.dpts = new ArrayList<>();
    }

    // busca todos os usuário
    public List<Departamento> findAll(){
        return new ArrayList<>(dpts);
    }

    // busca um user
    public Departamento getById(Long id){
        return dpts.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o user
    public boolean insert(Departamento user){
        dpts.add(user);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(Long id, Departamento departamento){
        Departamento departamentoBD = dpts.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBD == null){
            return false;
        }

        departamentoBD.setNome(departamento.getNome());

        return true;
    }

    public boolean delete(Long id) {
        Departamento departamentoBD = dpts.stream()
                .filter(departamentoFilter -> departamentoFilter.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBD == null) {
            return false;
        }
        dpts.remove(departamentoBD);
        return true;
    }
}
