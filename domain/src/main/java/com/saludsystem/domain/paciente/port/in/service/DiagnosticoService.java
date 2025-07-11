package com.saludsystem.domain.paciente.port.in.service;


import com.saludsystem.application.dto.get.DiagnosticoDTO;
import com.saludsystem.application.dto.post.CrearDiagnosticoDTO;
import com.saludsystem.application.dto.put.ActualizarDiagnosticoDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        DiagnosticoDTO,
        CrearDiagnosticoDTO,
        ActualizarDiagnosticoDTO,
        UUID> {
}