package com.example.SitAprendizagem1.View;

import com.example.SitAprendizagem1.Controller.EmprestimoController;
import com.example.SitAprendizagem1.Model.Cliente;
import com.example.SitAprendizagem1.Model.Emprestimo;
import com.example.SitAprendizagem1.Model.Livro;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoView {

    EmprestimoController emprestimoController = new EmprestimoController();

    @GetMapping
    public List<Emprestimo> getAll(){
        return emprestimoController.getAll();
    }

    @GetMapping("/{dataFim}")
    public Emprestimo getByDataFim(@PathVariable LocalDate dataFim){
        return emprestimoController.getByDataFim(dataFim);
    }

    @PostMapping
    public boolean insert(@RequestBody Emprestimo emprestimo){
        return emprestimoController.insert(emprestimo);
    }

    @PostMapping("/{idEmpresitmo}/livro")
    public boolean insertLivro(@PathVariable Long idEmpresitmo, @RequestBody Livro livro){
        return emprestimoController.insertLivro(idEmpresitmo, livro);
    }

    @PutMapping("/{idEmprestimo}/dataFim")
    public boolean updateData(@PathVariable Long idEmprestimo, @RequestBody LocalDate dataFim){
        return emprestimoController.updateData(idEmprestimo, dataFim);
    }

    @PutMapping("/{idEmprestimo}/cliente")
    public boolean updateData(@PathVariable Long idEmprestimo, @RequestBody Cliente cliente){
        return emprestimoController.updateCliente(idEmprestimo, cliente);
    }

    @DeleteMapping("/{idEmprestimo}")
    public boolean delete(@PathVariable Long idEmprestimo){
        return emprestimoController.delete(idEmprestimo);
    }

}
