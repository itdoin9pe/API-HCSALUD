package com.saludsystem.application.services.paciente.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.AntecedenteDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.ActualizarAntecedenteDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        AntecedenteDTO,
        UUID,
        CrearAntecedenteDTO,
        ActualizarAntecedenteDTO> {
}