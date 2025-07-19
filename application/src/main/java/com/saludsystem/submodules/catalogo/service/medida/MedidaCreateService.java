package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedidaDTO;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

public class MedidaCreateService {

    private final MedidaRepository medidaRepository;

    public MedidaCreateService(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public Medida execute(CrearMedidaDTO dto) {
        var medidaToSave = MedidaMapper.fromCreatDto(dto);
        return medidaRepository.save(medidaToSave);
    }
}
