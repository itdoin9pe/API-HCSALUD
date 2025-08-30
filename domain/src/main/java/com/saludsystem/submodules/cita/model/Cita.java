package com.saludsystem.submodules.cita.model;

import com.saludsystem.submodules.cita.model.vo.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
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

	public Cita(CitaId id, CitaEspecialidadId especialidadId, CitaDoctorId doctorId, LocalDate fecha,
			LocalTime horaInicio, LocalTime horaFin, CitaPacienteId pacienteId, CitaSedeId sedeId,
			CitaTipoCitadoId tipoCitadoId, String estado, CitaMotivoConsulta motivoConsulta,
			CitaObservacion observacion) {
		this.id=id;
		this.especialidadId=especialidadId;
		this.doctorId=doctorId;
		this.fecha=fecha;
		this.horaInicio=horaInicio;
		this.horaFin=horaFin;
		this.pacienteId=pacienteId;
		this.sedeId=sedeId;
		this.tipoCitadoId=tipoCitadoId;
		this.estado=estado;
		this.motivoConsulta=motivoConsulta;
		this.observacion=observacion;
	}
}