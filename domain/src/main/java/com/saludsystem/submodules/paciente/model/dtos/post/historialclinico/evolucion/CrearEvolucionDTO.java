package com.saludsystem.submodules.paciente.model.dtos.post.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.evolucion.NotaDTO;
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