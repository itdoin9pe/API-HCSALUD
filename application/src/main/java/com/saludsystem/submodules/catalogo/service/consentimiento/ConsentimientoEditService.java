package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

import java.util.UUID;

public class ConsentimientoEditService {

    private final ConsentimientoRepository consentimientoRepository;

    public ConsentimientoEditService(ConsentimientoRepository consentimientoRepository) {
        this.consentimientoRepository = consentimientoRepository;
    }

    public Consentimiento execute(UUID uuid, ActualizarConsentimientoDTO dto) {
        var updateToSave = ConsentimientoMapper.fromUpdateDto(uuid, dto);
        return consentimientoRepository.update(uuid, updateToSave);
    }
}