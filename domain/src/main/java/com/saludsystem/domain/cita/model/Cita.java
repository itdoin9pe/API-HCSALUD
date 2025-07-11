package com.saludsystem.domain.cita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Cita {
    private UUID id;
    private UUID especialidadId;
    private UUID doctorId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private UUID pacienteId;
    private UUID sedeId;
    private UUID tipoCitadoId;
    private String estado;
    private String motivoConsulta;
    private String observacion;
}