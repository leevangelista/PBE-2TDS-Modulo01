package com.precisiontech.cp.controller;

import com.precisiontech.cp.DTO.PecaDTORequest;
import com.precisiontech.cp.DTO.PecaDTOResponse;
import com.precisiontech.cp.entity.*;
import com.precisiontech.cp.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subpecas")
public class SubPecaController {

    @Autowired
    private SubPecaRepository subPecaRepository;

    @Autowired
    private FormatoRepository formatoRepository;


    @GetMapping
    public Iterable<SubPeca> getAllPecas() {
        return subPecaRepository.findAll();
    }

    @GetMapping("/{id}")
    public SubPeca getPecaById(@PathVariable Long id) {
        return subPecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub Peca not found with id: " + id));
    }

    @PostMapping("/subpeca")
    public SubPeca createSubPeca(@RequestBody SubPeca subPeca) {
        Formato formato = subPeca.getFormato();
        formato = formatoRepository.save(formato);
        subPeca.setFormato(formato);
        return subPecaRepository.save(subPeca);
    }

    @PutMapping("/{id}")
    public SubPeca updatePeca(@PathVariable Long id, @RequestBody SubPeca subPeca) {
        SubPeca existingSubPeca = subPecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub Peca not found with id: " + id));
        BeanUtils.copyProperties(subPeca, existingSubPeca, "id");
        existingSubPeca = subPecaRepository.save(existingSubPeca);
        return existingSubPeca;
    }

    @DeleteMapping("/{id}")
    public void deletePeca(@PathVariable Long id) {
        subPecaRepository.deleteById(id);
    }




}