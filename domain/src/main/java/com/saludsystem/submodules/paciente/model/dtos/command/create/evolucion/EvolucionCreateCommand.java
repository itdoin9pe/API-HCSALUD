package com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvolucionCreateCommand {

    private UUID pacienteId;

    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    private List<NotaDTO> notas;

    private List<CambioCondicionDTO> cambios;

    private UUID pacienteAltaMedicaId;

}