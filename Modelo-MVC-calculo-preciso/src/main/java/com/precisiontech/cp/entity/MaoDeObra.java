package com.precisiontech.cp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.precisiontech.cp.DTO.MaoDeObraDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MaoDeObra")
public class MaoDeObra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profissional;
    private double precoPorHora;

    @JsonIgnore
    @ManyToMany(mappedBy = "maosDeObra")
    private List<Peca> pecas = new ArrayList<>();

    public static MaoDeObraDTO fromEntity(MaoDeObra maoDeObra) {
        return new MaoDeObraDTO(
                maoDeObra.getId(),
                maoDeObra.getProfissional(),
                maoDeObra.getPrecoPorHora()
        );
    }


}
