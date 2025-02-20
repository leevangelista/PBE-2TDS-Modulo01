package com.precisiontech.cp.controller;

import com.precisiontech.cp.DTO.MaoDeObraDTO;
import com.precisiontech.cp.DTO.MaterialDTO;
import com.precisiontech.cp.DTO.PecaDTORequest;
import com.precisiontech.cp.DTO.PecaDTOResponse;
import com.precisiontech.cp.entity.*;
import com.precisiontech.cp.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    private final PecaRepository pecaRepository;

    private final MaterialRepository materialRepository;

    private final MaoDeObraRepository maoDeObraRepository;

    private final MaquinaRepository maquinaRepository;

    private final SubPecaRepository subPecaRepository;

    private final FormatoRepository formatoRepository;

    @Autowired
    public PecaController(PecaRepository pecaRepository, MaterialRepository materialRepository, MaoDeObraRepository maoDeObraRepository, MaquinaRepository maquinaRepository, SubPecaRepository subPecaRepository, FormatoRepository formatoRepository) {
        this.pecaRepository = pecaRepository;
        this.materialRepository = materialRepository;
        this.maoDeObraRepository = maoDeObraRepository;
        this.maquinaRepository = maquinaRepository;
        this.subPecaRepository = subPecaRepository;
        this.formatoRepository = formatoRepository;
    }

    @GetMapping
    public List<PecaDTOResponse> getAllPecas() {
        List<Peca> pecas = (List<Peca>) pecaRepository.findAll();
        return pecas.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/nome")
    public List<String> getNomes() {
        return pecaRepository.findNome();
    }

    @GetMapping("/codigo")
    public List<String> getCodigo() {
        return pecaRepository.findCodigo();
    }

    @GetMapping("/{id}")
    public PecaDTOResponse getPecaById(@PathVariable Long id) {
        Peca peca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peca not found with id: " + id));
        return toDTO(peca);
    }

    @PostMapping
    public PecaDTOResponse createPeca(@RequestBody PecaDTORequest pecaDTORequest) {
        Peca peca = fromDTO(pecaDTORequest);

        Peca finalPeca = pecaRepository.save(peca);

        Optional<Material> materialOptional = materialRepository.findById(finalPeca.getMaterial().getId());
        materialOptional.ifPresent(materialEntity -> {
            List<Peca> pecas = materialEntity.getPecas();
            pecas.add(finalPeca);

            materialRepository.save(materialEntity);
        });


        peca.getSubPecas().forEach(subPeca -> {
            if (subPeca.getFormato() != null) {
                subPeca.setPeca(finalPeca);
                formatoRepository.save(subPeca.getFormato());
            }
        });

        peca.getSubPecas().forEach(subPecaRepository::save);

        List<Maquina> maquinasAtualizadas = new ArrayList<>();

        peca.getMaquinas().forEach(maquina -> {
            List<Peca> pecas = new ArrayList<>(maquina.getPecas());
            pecas.add(finalPeca);
            maquina.setPecas(pecas);
            maquinasAtualizadas.add(maquina);
        });

        maquinaRepository.saveAll(maquinasAtualizadas);

        return toDTO(peca);
    }

    @PutMapping("/{id}")
    public PecaDTOResponse updatePeca(@PathVariable Long id, @RequestBody PecaDTORequest updatedPecaDTORequest) {
        Peca existingPeca = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peca not found with id: " + id));
        BeanUtils.copyProperties(fromDTO(updatedPecaDTORequest), existingPeca, "id");
        existingPeca = pecaRepository.save(existingPeca);
        return toDTO(existingPeca);
    }

    @DeleteMapping("/{id}")
    public void deletePeca(@PathVariable Long id) {
        pecaRepository.deleteById(id);
    }

    private PecaDTOResponse toDTO(Peca peca) {

        List<MaoDeObraDTO> maosDeObraDTO = peca.getMaosDeObra().stream()
                .map(MaoDeObra::fromEntity)
                .collect(Collectors.toList());

        MaterialDTO materialDTO = Material.fromEntity(peca.getMaterial());

        return new PecaDTOResponse(
                peca.getId(),
                peca.getCodigo(),
                peca.getNomeDaPeca(),
                peca.getVolumeTotal(),
                peca.getCustoDeProducao(),
                peca.getTempoDeUsinagem(),
                peca.getPesoTarugo(),
                peca.getQuantidadeDeCavaco(),
                peca.getValorDoCavaco(),
                peca.getDataDeCriacao(),
                maosDeObraDTO,
                peca.getMaquinas(),
                materialDTO,
                peca.getSubPecas()
        );
    }

    private Peca fromDTO(PecaDTORequest pecaDTORequest) {
        List<MaoDeObra> maosDeObra = pecaDTORequest.getMaosDeObraIds().stream()
                .map(maoDeObraId -> maoDeObraRepository.findById(maoDeObraId)
                        .orElseThrow(() -> new RuntimeException("Mão de obra not found with id: " + maoDeObraId)))
                .collect(Collectors.toList());

        List<Maquina> maquinas = pecaDTORequest.getMaquinas().stream()
                .map(maquinasIds -> maquinaRepository.findById(maquinasIds)
                        .orElseThrow(() -> new RuntimeException("Máquina not found with id: " + maquinasIds)))
                .collect(Collectors.toList());

        Material material = materialRepository.findById(pecaDTORequest.getMaterialId())
                .orElseThrow(() -> new RuntimeException("Material not found with id: " + pecaDTORequest.getMaterialId()));

        List<SubPeca> subPecas = pecaDTORequest.getSubPecas().stream()
                .map(subPecaDTO -> {
                    return subPecaDTO.convertToSubPeca(subPecaDTO);
                })
                .collect(Collectors.toList());


        Peca peca = new Peca();
        peca.setId(pecaDTORequest.getId());
        peca.setCodigo(pecaDTORequest.getCodigo());
        peca.setNomeDaPeca(pecaDTORequest.getNomeDaPeca());
        peca.setVolumeTotal(pecaDTORequest.getVolumeTotal());
        peca.setCustoDeProducao(pecaDTORequest.getCustoDeProducao());
        peca.setTempoDeUsinagem(pecaDTORequest.getTempoDeUsinagem());
        peca.setPesoTarugo(pecaDTORequest.getPesoTarugo());
        peca.setQuantidadeDeCavaco(pecaDTORequest.getQuantidadeDeCavaco());
        peca.setValorDoCavaco(pecaDTORequest.getValorDoCavaco());
        peca.setDataDeCriacao(Calendar.getInstance().getTime());
        peca.setMaosDeObra(maosDeObra);
            peca.setMaquinas(maquinas);
        peca.setSubPecas(subPecas);
        peca.setMaterial(material);

        return peca;
    }
}