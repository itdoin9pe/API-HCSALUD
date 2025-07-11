package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.AntecedenteDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarAntecedenteDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        AntecedenteDTO,
        CrearAntecedenteDTO,
        ActualizarAntecedenteDTO,
        UUID> {
}