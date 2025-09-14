package com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta;

import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.EstadoInterconsulta;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InterconsultaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.PrioridadInterconsulta;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;

public class InterconsultaDboMapper
{
	public static InterconsultaEntity toEntity(Interconsulta model, UUID hospitalId, UUID userId)
	{
		InterconsultaEntity entity = new InterconsultaEntity();
		entity.setPacienteInterconsultaId(model.getPacienteInterconsultaId());

		PacienteEntity paciente = new PacienteEntity();
		paciente.setPacienteId(model.getPacienteInterconsultaId());
		entity.setPacienteEntity(paciente);

		DoctorEntity doctor = new DoctorEntity();
		doctor.setDoctorId(model.getMedicoSolicitante());
		entity.setMedicoSolicitante(doctor);

		EspecialidadEntity especialidad = new EspecialidadEntity();
		especialidad.setEspecialidadId(model.getEspecialidadDestino());
		entity.setEspecialidadDestino(especialidad);
		entity.setMotivo(model.getMotivo());
		entity.setFechaSolicitud(model.getFechaSolicitud());
		entity.setEstado(EstadoInterconsulta.valueOf(model.getEstado()));
		entity.setPrioridad(PrioridadInterconsulta.valueOf(model.getPrioridad()));
		entity.setObservaciones(model.getObservaciones());
		entity.setFechaAtencion(model.getFechaAtencion());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Interconsulta toDomain(InterconsultaEntity entity)
	{
		return new Interconsulta(entity.getPacienteInterconsultaId(), entity.getPacienteEntity().getPacienteId(),
				entity.getMedicoSolicitante().getDoctorId(), entity.getEspecialidadDestino().getEspecialidadId(),
				entity.getMotivo(), entity.getFechaSolicitud(), entity.getEstado().name(), entity.getPrioridad().name(),
				entity.getObservaciones(), entity.getFechaAtencion());
	}
}
