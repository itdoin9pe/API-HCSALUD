package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.NotaDTO;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class CrearEvolucionDTO {

    private UUID pacienteId;

    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    private List<NotaDTO> notas;

    private List<CambioCondicionDTO> cambios;

    private UUID pacienteAltaMedicaId;

}