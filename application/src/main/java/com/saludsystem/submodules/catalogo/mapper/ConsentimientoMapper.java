package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarConsentimientoDTO;
import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.UUID;

public class ConsentimientoMapper {

    public static Consentimiento fromCreateDto(CrearConsentimientoDTO dto) {
        return new Consentimiento(null, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
    }

    public static Consentimiento fromUpdateDto(UUID uuid, ActualizarConsentimientoDTO dto) {
        return new Consentimiento(uuid, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
    }

    public static ConsentimientoDTO toDto(Consentimiento model) {
        return new ConsentimientoDTO(model.getId(), model.getTexto(), model.getNombre(),
                model.getObservacion(), model.getEstado());
    }

}
