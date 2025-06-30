package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarConsultaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        ConsultaDTO,
        UUID,
        CrearConsultaDTO,
        ActualizarConsultaDTO> {
}