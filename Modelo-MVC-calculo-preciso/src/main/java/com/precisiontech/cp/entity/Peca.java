package com.precisiontech.cp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Peca")
public class Peca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Peca_MaoDeObra",
            joinColumns = @JoinColumn(name = "peca_id"),
            inverseJoinColumns = @JoinColumn(name = "mao_de_obra_id")
    )
    private List<MaoDeObra> maosDeObra = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "material_id") // Chave estrangeira na tabela Peca
    private Material material;


    @ManyToMany(mappedBy = "pecas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Maquina> maquinas = new ArrayList<>();


    @OneToMany(mappedBy = "peca")
    private List<SubPeca> subPecas;


}