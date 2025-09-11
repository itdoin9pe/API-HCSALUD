package com.saludsystem.submodules.cita.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.saludsystem.submodules.cita.model.vo.CitaDoctorId;
import com.saludsystem.submodules.cita.model.vo.CitaEspecialidadId;
import com.saludsystem.submodules.cita.model.vo.CitaId;
import com.saludsystem.submodules.cita.model.vo.CitaMotivoConsulta;
import com.saludsystem.submodules.cita.model.vo.CitaObservacion;
import com.saludsystem.submodules.cita.model.vo.CitaPacienteId;
import com.saludsystem.submodules.cita.model.vo.CitaSedeId;
import com.saludsystem.submodules.cita.model.vo.CitaTipoCitadoId;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

	public void actualizarEspecialidad(CitaEspecialidadId especialidadId) {
        if (especialidadId != null) {
            this.especialidadId = especialidadId;
        }
    }
    public void actualizarDoctor(CitaDoctorId doctorId) {
        if (doctorId != null) {
            this.doctorId = doctorId;
        }
    }
    public void actualizarFecha(LocalDate fecha) {
        if (fecha != null) {
            this.fecha = fecha;
        }
    }
    public void actualizarHoraInicio(LocalTime horaInicio) {
        if (horaInicio != null) {
            this.horaInicio = horaInicio;
        }
    }
    public void actualizarHoraFin(LocalTime horaFin) {
        if (horaFin != null) {
            this.horaFin = horaFin;
        }
    }
    public void actualizarPaciente(CitaPacienteId pacienteId) {
        if (pacienteId != null) {
            this.pacienteId = pacienteId;
        }
    }
    public void actualizarSede(CitaSedeId sedeId) {
        if (sedeId != null) {
            this.sedeId = sedeId;
        }
    }
    public void actualizarTipoCitado(CitaTipoCitadoId tipoCitadoId) {
        if (tipoCitadoId != null) {
            this.tipoCitadoId = tipoCitadoId;
        }
    }
    public void actualizarEstado(String estado) {
        if (estado != null && !estado.isBlank()) {
            this.estado = estado;
        }
    }
    public void actualizarMotivoConsulta(CitaMotivoConsulta motivoConsulta) {
        if (motivoConsulta != null) {
            this.motivoConsulta = motivoConsulta;
        }
    }
    public void actualizarObservacion(CitaObservacion observacion) {
        if (observacion != null) {
            this.observacion = observacion;
        }
    }
}