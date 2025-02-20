package com.precisiontech.cp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PecaDTORequest {
    private Long id;
    private String codigo;
    private String nomeDaPeca;
    private Double volumeTotal; // vem do front
    private Double custoDeProducao; // (materia prima * kg da materia)
                                    // + (mao de obra * qtd de mao de obra * tempo)
                                    // + (máquinas * quantidade * tempo)
    private Double tempoDeUsinagem; // soma dos tempos do operador
    private Double pesoTarugo;
    private Double quantidadeDeCavaco; // peso do tarugo - peso da peça (volume * densidade)
    private Double valorDoCavaco;
    private List<Long> maosDeObraIds;
    private List<Long> maquinas;
    private Long materialId;
    private List<SubPecaDTORequest> subPecas;
}