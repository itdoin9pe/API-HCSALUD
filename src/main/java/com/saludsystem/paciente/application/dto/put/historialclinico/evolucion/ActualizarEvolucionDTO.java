package com.saludsystem.paciente.application.dto.put.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.NotaDTO;
import com.saludsystem.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEvolucionDTO extends BaseDTO {

    private UUID pacienteEvolucionId;

    private UUID pacienteId;

    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    private List<NotaDTO> notas;

    private List<CambioCondicionDTO> cambios;

    private UUID pacienteAltaMedicaId;

}