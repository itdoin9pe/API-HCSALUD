package com.saludsystem.application.dtos.cita.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ActualizarCitaDTO {
    private UUID hospitalId;
    private UUID userId;
    private UUID citadoId;
    private UUID especialidadEntity;
    private UUID doctorEntity;
    private LocalDate fecha;
    @Schema(example = "10:00:00")
    private LocalTime horaInicio;
    @Schema(example = "11:00:00")
    private LocalTime horaFin;
    private UUID pacienteEntity;
    private UUID sedeEntity;
    private UUID tipoCitadoEntity;
    private String estado;
    private String motivoConsulta;
    private String observacion;
}