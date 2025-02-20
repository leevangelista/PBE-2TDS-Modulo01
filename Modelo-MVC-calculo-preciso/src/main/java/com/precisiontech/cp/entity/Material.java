package com.precisiontech.cp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.precisiontech.cp.DTO.MaterialDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_por_kg")
    private Double precoPorKg;

    @Column(name = "preco_cavaco")
    private Double precoCavaco;

    @Column(name= "densidade")
    private Double densidade;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "material")
    private List<Peca> pecas;

    public static MaterialDTO fromEntity(Material material) {
        return new MaterialDTO(
                material.getId(),
                material.getNome(),
                material.getPrecoPorKg(),
                material.getPrecoCavaco(),
                material.getDensidade()
        );
    }

}