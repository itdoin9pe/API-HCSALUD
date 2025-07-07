package com.saludsystem.application.services.cita;

import com.saludsystem.application.dtos.cita.get.CitaDTO;
import com.saludsystem.application.dtos.cita.post.CrearCitaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CitaService extends GenericService<
        CrearCitaDTO,
        CitaDTO,
        UUID> {
}