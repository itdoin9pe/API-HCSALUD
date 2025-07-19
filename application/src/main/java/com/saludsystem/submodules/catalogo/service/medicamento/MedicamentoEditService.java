package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarMedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

import java.util.UUID;

public class MedicamentoEditService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoEditService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento execute(UUID uuid, ActualizarMedicamentoDTO dto) {
        var updateToSave = MedicamentoMapper.fromUpdateDto(uuid, dto);
        return medicamentoRepository.update(uuid, updateToSave);
    }
}
