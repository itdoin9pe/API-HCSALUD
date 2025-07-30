package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

public class ConsentimientoCreateService {

    private final ConsentimientoRepository consentimientoRepository;

    public ConsentimientoCreateService(ConsentimientoRepository consentimientoRepository) {
        this.consentimientoRepository = consentimientoRepository;
    }

    public Consentimiento execute(ConsentimientoCreateCommand dto) {
        var consentimientoToCreate = ConsentimientoMapper.fromCreateDto(dto);
        return consentimientoRepository.save(consentimientoToCreate);
    }
}
