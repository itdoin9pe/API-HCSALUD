package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.AntecedenteDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        CrearAntecedenteDTO,
        AntecedenteDTO,
        UUID> {
}