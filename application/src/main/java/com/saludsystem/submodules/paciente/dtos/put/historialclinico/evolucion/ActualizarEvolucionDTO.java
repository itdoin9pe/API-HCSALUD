package com.saludsystem.submodules.paciente.dtos.put.historialclinico.evolucion;

import com.saludsystem.submodules.BaseDTO;
import com.saludsystem.submodules.paciente.dtos.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.dtos.get.historialclinico.evolucion.NotaDTO;
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