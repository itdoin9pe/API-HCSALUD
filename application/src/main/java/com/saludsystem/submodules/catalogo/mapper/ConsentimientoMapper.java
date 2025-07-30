package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarConsentimientoDTO;
import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.UUID;

public class ConsentimientoMapper {

    public static Consentimiento fromCreateDto(ConsentimientoCreateCommand dto) {
        return new Consentimiento(null, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
    }

    public static Consentimiento fromUpdateDto(UUID uuid, ActualizarConsentimientoDTO dto) {
        return new Consentimiento(uuid, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
    }

    public static ConsentimientoCreateCommand toDto(Consentimiento model) {
        return new ConsentimientoCreateCommand(model.getId(), model.getTexto(), model.getNombre(),
                model.getObservacion(), model.getEstado());
    }

}
