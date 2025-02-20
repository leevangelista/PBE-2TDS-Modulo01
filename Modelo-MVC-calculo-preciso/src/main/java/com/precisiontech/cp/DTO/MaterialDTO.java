package com.precisiontech.cp.DTO;

import com.precisiontech.cp.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {
    private Long id;
    private String nome;
    private Double precoPorKg;
    private Double precoCavaco;
    private Double densidade;
}