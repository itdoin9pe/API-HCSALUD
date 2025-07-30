package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

public class MedicamentoCreateService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoCreateService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento execute(MedicamentoCreateCommand medicamentoCreateCommand) {
        var medicamentoToCreate = MedicamentoMapper.fromCreateDto(medicamentoCreateCommand);
        return medicamentoRepository.save(medicamentoToCreate);
    }
}
