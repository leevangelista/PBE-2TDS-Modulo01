package com.precisiontech.cp.repository;

import com.precisiontech.cp.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
