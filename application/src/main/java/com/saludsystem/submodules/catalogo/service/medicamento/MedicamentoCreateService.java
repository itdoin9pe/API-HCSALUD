package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

public class MedicamentoCreateService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoCreateService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento execute(CrearMedicamentoDTO crearMedicamentoDTO) {
        var medicamentoToCreate = MedicamentoMapper.fromCreateDto(crearMedicamentoDTO);
        return medicamentoRepository.save(medicamentoToCreate);
    }
}
