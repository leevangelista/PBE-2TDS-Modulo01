package com.precisiontech.cp.repository;

import com.precisiontech.cp.entity.Maquina;
import com.precisiontech.cp.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

}
