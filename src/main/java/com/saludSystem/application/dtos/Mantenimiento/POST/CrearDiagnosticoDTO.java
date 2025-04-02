package com.saludSystem.application.dtos.Mantenimiento.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CrearDiagnosticoDTO {

    //private UUID pacienteId;

    private String enfermedadId;

    private String nombreEnfermedad;

    private LocalDate fecha;

    @Schema(description = "Estado de Diagnostico (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}