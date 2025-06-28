package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.DiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface DiagnosticoService extends GenericService<
        DiagnosticoDTO,
        UUID,
        CrearDiagnosticoDTO,
        ActualizarDiagnosticoDTO> {
}