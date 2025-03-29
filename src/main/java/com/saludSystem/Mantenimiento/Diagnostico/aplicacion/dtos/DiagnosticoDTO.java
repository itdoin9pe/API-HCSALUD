package com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DiagnosticoDTO {

    private UUID diagnosticoId;

    //private UUID pacienteId;

    private String enfermedadId;

    private String nombreEnfermedad;

    private LocalDate fecha;

    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}