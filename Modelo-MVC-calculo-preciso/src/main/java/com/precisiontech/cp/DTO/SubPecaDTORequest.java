package com.precisiontech.cp.DTO;

import com.precisiontech.cp.entity.Cilindro;
import com.precisiontech.cp.entity.Piramide;
import com.precisiontech.cp.entity.SubPeca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPecaDTORequest {
    private Long id;
    private String nome;
    private String volume;
    private Double raio;
    private Double alturaCilindro;
    private String tipoBasePiramide;
    private Double ladoPiramide;
    private Double alturaPiramide;
    // Outros campos, se necessário

    public SubPecaDTORequest(SubPeca subPeca) {
        this.id = subPeca.getId();
        this.nome = subPeca.getNome();
        if (subPeca.getFormato() instanceof Cilindro) {
            Cilindro cilindro = (Cilindro) subPeca.getFormato();
            this.volume = cilindro.getVolume();
            this.raio = cilindro.getRaio();
            this.alturaCilindro = cilindro.getAltura();
        } else if (subPeca.getFormato() instanceof Piramide) {
            Piramide piramide = (Piramide) subPeca.getFormato();
            this.volume = piramide.getVolume();
            this.tipoBasePiramide = piramide.getTipoBase();
            this.ladoPiramide = piramide.getLado();
            this.alturaPiramide = piramide.getAltura();
        }
    }

    public SubPeca convertToSubPeca(SubPecaDTORequest subPecaDTO) {
        SubPeca subPeca = new SubPeca();
        subPeca.setId(subPecaDTO.getId());
        subPeca.setNome(subPecaDTO.getNome());

        if (subPecaDTO.getTipoBasePiramide() != null) {
            Piramide piramide = new Piramide();
            piramide.setVolume(subPecaDTO.getVolume());
            piramide.setTipoBase(subPecaDTO.getTipoBasePiramide());
            piramide.setLado(subPecaDTO.getLadoPiramide());
            piramide.setAltura(subPecaDTO.getAlturaPiramide());
            subPeca.setFormato(piramide);
        } else {
            Cilindro cilindro = new Cilindro();
            cilindro.setVolume(subPecaDTO.getVolume());
            cilindro.setRaio(subPecaDTO.getRaio());
            cilindro.setAltura(subPecaDTO.getAlturaCilindro());
            subPeca.setFormato(cilindro);
        }

        return subPeca;
    }
}