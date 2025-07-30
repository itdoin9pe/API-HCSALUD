package com.saludsystem.submodules.cita.model.entity;

import com.saludsystem.submodules.cita.vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class Cita {

    private CitaId id;
    private CitaEspecialidadId especialidadId;
    private CitaDoctorId doctorId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private CitaPacienteId pacienteId;
    private CitaSedeId sedeId;
    private CitaTipoCitadoId tipoCitadoId;
    private String estado;
    private CitaMotivoConsulta motivoConsulta;
    private CitaObservacion observacion;

}