package com.precisiontech.cp.DTO;

import com.precisiontech.cp.entity.MaoDeObra;
import com.precisiontech.cp.entity.Maquina;
import com.precisiontech.cp.entity.Material;
import com.precisiontech.cp.entity.SubPeca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PecaDTOResponse {
    private Long id;
    private String codigo;
    private String nomeDaPeca;
    private Double volumeTotal; // vem do front
    private Double custoDeProducao; // (materia prima * kg da materia) + (mao de obra * qtd de mao de obra * tempo) + (máquinas * quantidade * tempo)
    private Double tempoDeUsinagem; // soma dos tempos do operador
    private Double pesoTarugo;
    private Double quantidadeDeCavaco;
    private Double valorDoCavaco;
    private Date dataDeCriacao;
    private List<MaoDeObraDTO> maosDeObra;
    private List<Maquina> maquina;
    private MaterialDTO material;
    private List<SubPeca> subPecas;
}