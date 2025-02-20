package com.example.ex9.banco;

import com.example.ex9.model.Departamento;
import com.example.ex9.model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioBd {

    private List<Funcionario> funcionarios;


    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }
    //buscar duncionarios
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }

    public List<Funcionario> findByCurso(String curso){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getCurso().equals(curso))
                .toList();
    }

    public List<Funcionario> findByDepartamento(String nomeDepartamento){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getDepartamento().getNome()
                .equals(nomeDepartamento))
                .toList();

    }


    //buscar unico funcionario
    public Funcionario getById(Long id){
        return funcionarios.stream()
                .filter(func -> func.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //inserir func
    public boolean insert (Funcionario funcionario){
        funcionarios.add(funcionario);
         return true;
    }

// atualizar func
    public boolean update (Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

            if(funcionarioBd == null){
                return false;
            }
            funcionarioBd.setCurso(funcionario.getCurso());
            funcionarioBd.setDepartamento(funcionario.getDepartamento());
            funcionarioBd.setNome(funcionario.getNome());
            funcionarioBd.setSobrenome(funcionario.getSobrenome());
            funcionarioBd.setSalario(funcionario.getSalario());


            return true;
    }

    public boolean delete (Long id){
        Funcionario f = funcionarios.stream()
                .filter(fBd -> fBd.getId() == id)
                .findFirst()
                .orElse(null);

        if(f == null){
            return false;
        }
        funcionarios.remove(f);
        return true;
    }


    //ORDENAR POR SALARIO
   // public  List<Funcionario> funcionariosOrdenados(){
      //  return funcionarios.stream()
     //           .sorted((func1, func2) -> Double.compare(func2.getSalario(), func1.getSalario()))
     //           .toList();

   // }
    //SEGUNDA OPCAO
    public List<Funcionario> funcionariosOrdenados(){
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .toList();
    }


}
