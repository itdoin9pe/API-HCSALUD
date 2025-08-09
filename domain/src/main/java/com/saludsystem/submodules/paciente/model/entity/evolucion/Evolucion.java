package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Evolucion {

    private UUID pacienteEvolucionId;
    private UUID pacienteId;
    private LocalDateTime fechaInicio;
    private Boolean finalizada = false;
    private List<Nota> notas;
    private List<CambioCondicion> cambios;
    private Long altaMedicaId;

}
