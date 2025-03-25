package com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearDiagnosticoDTO {

    private UUID pacienteId;

    private String enfermedadId;

    private String nombreEnfermedad;

    private LocalDate fecha;

    private Integer estado;

}