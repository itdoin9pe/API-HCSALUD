package com.saludsystem.paciente.application.dto.base.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.CambioCondicionResponse;
import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.NotaResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public abstract class EvolucionBaseDTO {
    private UUID pacienteId;

    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    private List<NotaResponse> notas;

    private List<CambioCondicionResponse> cambios;

    private UUID pacienteAltaMedicaId;
}