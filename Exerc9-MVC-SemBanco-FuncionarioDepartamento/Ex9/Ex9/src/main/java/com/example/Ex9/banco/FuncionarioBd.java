package com.example.Ex9.banco;

import com.example.Ex9.Model.Funcionario;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd() {
        this.funcionarios = new ArrayList<>();
    }
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }
    public Funcionario getById(long id){
        return funcionarios.stream()
                .filter( fun -> fun.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Funcionario> findByCurso(String curso) {
         return funcionarios.stream()
                .filter(objeto -> objeto.getCurso().equals(curso))
                 .toList();
    }
    public List<Funcionario> findByDepartamento(String nomeDepartamento) {
        return funcionarios.stream()
                .filter(objeto -> objeto.getDepartamento().getNome().equals(nomeDepartamento))
                .toList();
    }
    public List<Funcionario> funcionariosOrdenados(Double salario) {
        return funcionarios.stream()
                .sorted((fun1, fun2)-> Double.compare(fun2.getSalario(), fun1.getSalario()))
                .toList();
    }
    public boolean insert(Funcionario funcionario){
        funcionarios.add(funcionario);
        return true;
    }
    public boolean update(long id, Funcionario funcionario) {
        Funcionario funcionarioBD = funcionarios.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst()
                .orElse(null);
        if (funcionarioBD == null){
            return false;
        }
        funcionarioBD.setNome(funcionario.getNome());
        funcionarioBD.setSobrenome(funcionario.getSobrenome());
        funcionarioBD.setCurso(funcionario.getCurso());
        funcionarioBD.setDepartamento(funcionario.getDepartamento());
        funcionarioBD.setSalario(funcionario.getSalario());
        return true;
    }
    public boolean removerFuncionario(@PathVariable Long id) {
        return funcionarios.removeIf(f -> f.getId() == (id));
    }


}
