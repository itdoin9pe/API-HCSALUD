package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarPacienteAlergiaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PacienteAlergiaService extends GenericService<
        PacienteAlergiaDTO,
        UUID,
        CrearPacienteAlergiaDTO,
        ActualizarPacienteAlergiaDTO> {
}