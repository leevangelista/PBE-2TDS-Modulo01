package com.precisiontech.cp.repository;

import com.precisiontech.cp.entity.Peca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PecaRepository extends CrudRepository<Peca, Long> {
    @Query("SELECT p.codigo FROM Peca p")
    List<String> findCodigo();

    @Query("SELECT p.nomeDaPeca FROM Peca p")
    List<String> findNome();

}