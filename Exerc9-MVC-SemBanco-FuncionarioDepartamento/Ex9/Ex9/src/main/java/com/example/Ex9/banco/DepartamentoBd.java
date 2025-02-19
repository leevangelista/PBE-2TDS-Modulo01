package com.example.Ex9.banco;

import com.example.Ex9.Model.Departamento;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {

        private List<Departamento> departamentos;

        public DepartamentoBd() {
            this.departamentos = new ArrayList<>();
        }

        //buscar todos os usuarios
        public List<Departamento> findAll(){
            return new ArrayList<>(departamentos);
        }
        //buscar apenas um usuario
        public Departamento getById(long id){
            return departamentos.stream()
                    .filter( dep -> dep.getId() == id)
                    .findFirst()
                    .orElse(null);
        }
        // insert user
        public boolean insert(Departamento departamento){
            departamentos.add(departamento);
            return true;
        }

        //update user
        public boolean update(long id, Departamento departamento) {
            Departamento departamentoBD = departamentos.stream()
                    .filter(objeto -> objeto.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (departamentoBD == null){
                return false;
            }
           departamentoBD.setNome(departamento.getNome());
            return true;
        }
        public boolean removerDepartamento(@PathVariable Long id) {
           return departamentos.removeIf(f -> f.getId() == (id));
        }
}


