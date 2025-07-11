package com.saludsystem.application.cita.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class CrearCitaDTO {
    private UUID tipoCitadoId;
    private UUID especialidadId;
    private UUID doctorId;
    private LocalDate fecha;
    @Schema(example = "10:00:00")
    private LocalTime horaInicio;
    @Schema(example = "11:00:00")
    private LocalTime horaFin;
    private UUID pacienteId;
    private UUID sedeId;
    private String estado;
    private String motivoConsulta;
    private String observacion;
}