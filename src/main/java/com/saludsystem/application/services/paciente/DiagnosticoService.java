package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.DiagnosticoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearDiagnosticoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarDiagnosticoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        DiagnosticoDTO,
        UUID,
        CrearDiagnosticoDTO,
        ActualizarDiagnosticoDTO> {
}