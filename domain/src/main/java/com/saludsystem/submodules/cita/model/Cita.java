package com.saludsystem.submodules.cita.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.saludsystem.submodules.cita.model.enums.EstadoCitaEnum;
import com.saludsystem.submodules.cita.model.vo.CitaDoctorId;
import com.saludsystem.submodules.cita.model.vo.CitaEspecialidadId;
import com.saludsystem.submodules.cita.model.vo.CitaEstado;
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
public class Cita
{
	private CitaId id;
	private CitaEspecialidadId especialidadId;
	private CitaDoctorId doctorId;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private CitaPacienteId pacienteId;
	private CitaSedeId sedeId;
	private CitaTipoCitadoId tipoCitadoId;
	private CitaEstado estado;
	private CitaMotivoConsulta motivoConsulta;
	private CitaObservacion observacion;
	private LocalDateTime checkedInAt;

	public Cita(
		CitaId id,
		CitaEspecialidadId especialidadId,
		CitaDoctorId doctorId,
		LocalDate fecha,
		LocalTime horaInicio,
		LocalTime horaFin,
		CitaPacienteId pacienteId,
		CitaSedeId sedeId,
		CitaTipoCitadoId tipoCitadoId,
		CitaEstado estado,
		CitaMotivoConsulta motivoConsulta,
		CitaObservacion observacion)
	{
		this.id = id;
		this.especialidadId = especialidadId;
		this.doctorId = doctorId;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.pacienteId = pacienteId;
		this.sedeId = sedeId;
		this.tipoCitadoId = tipoCitadoId;
		this.estado = estado;
		this.motivoConsulta = motivoConsulta;
		this.observacion = observacion;
	}

	public void actualizarEspecialidad(CitaEspecialidadId especialidadId)
	{
		if (especialidadId != null)
		{
			this.especialidadId = especialidadId;
		}
	}

	public void actualizarDoctor(CitaDoctorId doctorId)
	{
		if (doctorId != null)
		{
			this.doctorId = doctorId;
		}
	}

	public void actualizarFecha(LocalDate fecha)
	{
		if (fecha != null)
		{
			this.fecha = fecha;
		}
	}

	public void actualizarHoraInicio(LocalTime horaInicio)
	{
		if (horaInicio != null)
		{
			this.horaInicio = horaInicio;
		}
	}

	public void actualizarHoraFin(LocalTime horaFin)
	{
		if (horaFin != null)
		{
			this.horaFin = horaFin;
		}
	}

	public void actualizarPaciente(CitaPacienteId pacienteId)
	{
		if (pacienteId != null)
		{
			this.pacienteId = pacienteId;
		}
	}

	public void actualizarSede(CitaSedeId sedeId)
	{
		if (sedeId != null)
		{
			this.sedeId = sedeId;
		}
	}

	public void actualizarTipoCitado(CitaTipoCitadoId tipoCitadoId)
	{
		if (tipoCitadoId != null)
		{
			this.tipoCitadoId = tipoCitadoId;
		}
	}

	public void actualizarEstado(CitaEstado estado)
	{
		if (estado != null)
		{
			this.estado = estado;
		}
	}

	public void actualizarMotivoConsulta(CitaMotivoConsulta motivoConsulta)
	{
		if (motivoConsulta != null)
		{
			this.motivoConsulta = motivoConsulta;
		}
	}

	public void actualizarObservacion(CitaObservacion observacion)
	{
		if (observacion != null)
		{
			this.observacion = observacion;
		}
	}

	public void confirmar()
	{
		if (estado.value() != EstadoCitaEnum.ACTIVA)
		{
			throw new IllegalStateException("Solo se pueden confirmar citas activas.");
		}
		this.estado = new CitaEstado(EstadoCitaEnum.CONFIRMADA);
	}

	public boolean seCruzaCon(Cita otra)
	{
		if (!this.doctorId.equals(otra.doctorId))
		{
			return false;
		}
		if (!this.fecha.equals(otra.fecha))
		{
			return false;
		}
		return this.horaInicio.isBefore(otra.horaFin) && this.horaFin.isAfter(otra.horaInicio);
	}

	public void checkIn()
	{
		if (estado.value() != EstadoCitaEnum.CONFIRMADA)
		{
			throw new IllegalStateException("Solo se pueden hacer check-in de citas confirmadas.");
		}
		this.estado = new CitaEstado(EstadoCitaEnum.CHECKED_IN);
	}

	public void doCheckIn()
	{
		if (estado.value() != EstadoCitaEnum.RESERVADA)
		{
			throw new IllegalStateException("Solo se puede hacer check-in en una cita RESERVADA");
		}
		this.estado = new CitaEstado(EstadoCitaEnum.EN_CURSO);
		this.checkedInAt = LocalDateTime.now();
	}

	public void cambiarEstado(EstadoCitaEnum nuevoEstado)
	{
		if (this.estado.value() == EstadoCitaEnum.CANCELADA)
		{
			throw new IllegalStateException("No se puede cambiar el estado de una cita cancelada");
		}
		this.estado = new CitaEstado(nuevoEstado);
	}

	public void finalizar()
	{
		if (!estado.esFinalizable())
		{
			throw new IllegalStateException("La cita debe estar en check-in para finalizarse.");
		}
		this.estado = new CitaEstado(EstadoCitaEnum.FINALIZADA);
	}

}