package com.saludsystem.paciente.application.dto.res.historialclinico.evolucion;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class EvolucionDTO {

    private UUID pacienteEvolucionId;

    private UUID pacienteId;

    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    private List<NotaResponse> notas;

    private List<CambioCondicionResponse> cambios;

    private UUID pacienteAltaMedicaId;

}