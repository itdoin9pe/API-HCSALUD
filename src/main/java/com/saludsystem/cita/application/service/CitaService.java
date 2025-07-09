package com.saludsystem.cita.application.service;

import com.saludsystem.cita.application.dto.post.CrearCitaDTO;
import com.saludsystem.cita.application.dto.get.CitaDTO;
import com.saludsystem.cita.application.dto.put.ActualizarCitaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CitaService extends GenericService<
        CitaDTO,
        CrearCitaDTO,
        ActualizarCitaDTO,
        UUID> {
}