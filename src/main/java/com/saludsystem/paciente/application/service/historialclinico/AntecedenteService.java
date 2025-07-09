package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.AntecedenteDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarAntecedenteDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        AntecedenteDTO,
        CrearAntecedenteDTO,
        ActualizarAntecedenteDTO,
        UUID> {
}