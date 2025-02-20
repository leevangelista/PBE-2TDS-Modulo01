package com.example.demo.banco;

import com.example.demo.model.Departamento;
import com.example.demo.model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }
    public List<Funcionario> findByCurso(String curso){
        return funcionarios.stream()
                .filter( funcionario -> funcionario.getCurso().equals(curso))
                .toList();
    }
    public List<Funcionario> findByDepartamento(String nomeDepartamento){
        return funcionarios.stream()
                .filter( funcionario -> funcionario.getDepartamento().getNome().equals(nomeDepartamento))
                .toList();
    }
    public List<Funcionario> funcionariosOrdenados(){
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .toList();
    }
    public Funcionario getById(long id){
        return funcionarios.stream()
                .filter( funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insert departamento
    public boolean insert(Funcionario funcionario){
        funcionarios.add(funcionario);
        return true;
    }
    public boolean update(Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter( funcionario1 -> funcionario1.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionarioBd == null){
            return false;
        }
        funcionarioBd.setNome(funcionario.getNome());
        return true;
    }
    public boolean delete(Long id){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter( funcionario1 -> funcionario1.getId() == id)
                .findFirst()
                .orElse(null);
        if (funcionarioBd == null){
            return false;
        }
        funcionarios.remove(funcionarioBd);
        return true;
    }

}
