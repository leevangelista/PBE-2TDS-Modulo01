package com.example.Ex9.Banco;

import com.example.Ex9.Model.Departamento;
import com.example.Ex9.Model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioBd {
    public List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }

    //busca todos funcionarios
    public List<Funcionario> findAll() {
        return new ArrayList<>(funcionarios);
    }

    //busca um funcionario
    public Funcionario getById(Long id) {
        return funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Funcionario getByCurso(String curso) {
        return funcionarios.stream()
                .filter(f -> f.getCurso().equals(curso))
                .findFirst()
                .orElse(null);
    }

    public Funcionario getByDepartamento(String nome) {
        return funcionarios.stream()
                .filter(f -> f.getDepartamento().getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    //insere um funcionario
    public boolean insert(Funcionario funcionario) {
        funcionarios.add(funcionario);
        return true;
    }

    //atualiza o funcionario com base no id
    public boolean update(Long id, Funcionario funcionario) {
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionarioBd == null) {
            return false;
        }

        funcionarioBd.setNome(funcionario.getNome());

        return true;
    }

    //deleta um funcionario com base no id
    public boolean delete(Long id) {
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionarioBd == null) {
            return false;
        }

        funcionarios.remove(funcionarioBd);
        return true;
    }

    public List<Funcionario> getFuncionariosOrdenadosPorSalario() {
        return funcionarios.stream()
                .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
                .collect(Collectors.toList());
    }
}
