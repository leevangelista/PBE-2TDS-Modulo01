package com.example.Ex9.banco;

import com.example.Ex9.model.Departamento;
import com.example.Ex9.model.Funcionario;
import com.example.Ex9.model.Gerente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd(){

        this.funcionarios = new ArrayList<>();

        // Criando os Gerentes
        Gerente gerente1 = new Gerente(1L, "Lucas");
        Gerente gerente2 = new Gerente(2L, "Joao");
        ArrayList<Gerente> gerentes = new ArrayList<>();
        gerentes.add(gerente1);
        gerentes.add(gerente2);

        // Criando os departamentos
        Departamento dep1 = new Departamento(1L, "Informática", gerentes);
        Departamento dep2 = new Departamento(2L, "Mecânica", gerentes);

        // Criando e adicionando funcionários na lista
        funcionarios.add(new Funcionario(1L, "Leonardo", "string", "html", 0.3, dep1));
        funcionarios.add(new Funcionario(2L, "Leonardo", "string", "motor", 0.4, dep2));
        funcionarios.add(new Funcionario(2L, "Leonardo", "string", "motor", 0.1, dep2));
    }

    // busca todos os funcionários
    public List<Funcionario> findAll(){
        return funcionarios.stream()
//                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .sorted((func1, func2) -> Double.compare(func2.getSalario(), func1.getSalario()))
                .toList();
    }

    public List<Funcionario> findByCurso(String curso){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getCurso().equals(curso))
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .toList();
    }

    public List<Funcionario> findByDepartamento(String departamento){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getDepartamento().getNome().equals(departamento))
                .toList();
    }

    // busca um funcionário
    public Funcionario getById(int id){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o funcionário
    public boolean insert(Funcionario funcionario){
        funcionarios.add(funcionario);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(int id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionarioBd == null){
            return false;
        }

        funcionarioBd.setNome(funcionario.getNome());
        funcionarioBd.setSobrenome(funcionario.getSobrenome());
        funcionarioBd.setCurso(funcionario.getCurso());
        funcionarioBd.setSalario(funcionario.getSalario());
        funcionarioBd.setDepartamento(funcionario.getDepartamento());

        return true;
    }

    public boolean delete(int id){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        funcionarios.remove(funcionarioBd);

        return true;
    }
}
