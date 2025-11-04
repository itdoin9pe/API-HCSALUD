package com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.AlergiaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.PacienteAlergiaEntity;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;

public class PacienteAlergiaDboMapper
{
	public static PacienteAlergiaEntity toEntity(PacienteAlergia model, UUID userId, UUID hospitalId)
	{
		PacienteAlergiaEntity entity = new PacienteAlergiaEntity();
		entity.setPacienteAlergiaId(model.getPacienteAlergiaId());
		// Paciente
		var pacienteEntity = new PacienteEntity();
		pacienteEntity.setPacienteId(model.getPacienteId());
		entity.setPacienteEntity(pacienteEntity);
		// Alergia
		var alergiaEntity = new AlergiaEntity();
		alergiaEntity.setAlergiaId(model.getAlergiaId());
		entity.setAlergiaEntity(alergiaEntity);
		// Campos simples
		entity.setObservacion(model.getObservacion());
		entity.setEstado(model.getEstado());
		// Usuario
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);
		// Hospital
		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);
		return entity;
	}

	public static PacienteAlergia toDomain(PacienteAlergiaEntity entity)
	{
		return new PacienteAlergia(entity.getPacienteAlergiaId(), entity.getPacienteEntity().getPacienteId(),
				entity.getAlergiaEntity().getAlergiaId(), entity.getObservacion(), entity.getEstado());
	}
}