package com.saludSystem.application.dtos.Paciente.GET.Evolucion;

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

    private List<NotaDTO> notas;

    private List<CambioCondicionDTO> cambios;

    private UUID pacienteAltaMedicaId;

}