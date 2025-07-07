package com.saludsystem.cita;

import com.saludsystem.cita.application.dto.res.CitaDTO;
import com.saludsystem.cita.application.dto.req.CrearCitaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CitaService extends GenericService<
        CrearCitaDTO,
        CitaDTO,
        UUID> {
}