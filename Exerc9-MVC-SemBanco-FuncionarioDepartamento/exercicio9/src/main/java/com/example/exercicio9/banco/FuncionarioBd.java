package com.example.exercicio9.banco;

import com.example.exercicio9.model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioBd {

    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }

    public List<Funcionario> findByCurso(String curso){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getCurso().equals(curso))
                .toList();
    }
    public List<Funcionario> findByDepartamento(String nomeDepartamento){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getDepartamento().getNome().equals(nomeDepartamento))
                .toList();
    }


   /*public List<Funcionario> funcionariosOrdenados(){
        return funcionarios.stream()
                .sorted((func1, func2) -> Double.compare(func2.getSalario(), func1.getSalario()))
        .toList();
   }*/

   public List<Funcionario> funcionariosOrdenados(){
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
                .toList();
   }





    //buscar todos os funcionarios

    public  List<Funcionario> findAll(){
        return  new ArrayList<>(funcionarios);
    }

    //busca um funcionario

    public Funcionario getByID(Long id){
        return  funcionarios.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //insere um funcionario

    public boolean insert(Funcionario funcionario) {
        funcionarios.add(funcionario);
        return true;
    }

    //atualiza o funconario pelo id

    public  boolean update(Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if(funcionarioBd == null){
            return false;
        }

        funcionarioBd.setNome(funcionario.getNome());

        return true;
    }

    public boolean delete(Long id){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(del -> del.getId() == id)
                .findFirst()
                .orElse(null);
        if(funcionarioBd == null){
            return false;
        }

        funcionarios.remove(funcionarioBd);
        return true;
    }
}
