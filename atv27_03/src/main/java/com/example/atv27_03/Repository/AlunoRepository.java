package com.example.atv27_03.Repository;

import com.example.atv27_03.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
