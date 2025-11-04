package com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ExploracionFisicaEntity;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;

public class ExploracionFisicaDboMapper
{
	public static ExploracionFisicaEntity toEntity(ExploracionFisica model, UUID userId, UUID hospitalId)
	{
		ExploracionFisicaEntity entity = new ExploracionFisicaEntity();
		entity.setPacienteExploracionId(model.getPacienteExploracionId());
		// Paciente
		var pacienteEntity = new PacienteEntity();
		pacienteEntity.setPacienteId(model.getPacienteId());
		entity.setPacienteEntity(pacienteEntity);
		// Campos simples
		entity.setPresionArterial(model.getPresionArterial());
		entity.setPulso(model.getPulso());
		entity.setTemperatura(model.getTemperatura());
		entity.setFrecuenciaCardiaca(model.getFrecuenciaCardiaca());
		entity.setFrecuenciaRespiratoria(model.getFrecuenciaRespiratoria());
		entity.setPeso(model.getPeso());
		entity.setTalla(model.getTalla());
		entity.setMasa(model.getMasa());
		entity.setExamenClinico(model.getExamenClinico());
		entity.setComplementoExamen(model.getComplementoExamen());
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

	public static ExploracionFisica toDomain(ExploracionFisicaEntity entity)
	{
		return new ExploracionFisica(entity.getPacienteExploracionId(), entity.getPacienteEntity().getPacienteId(),
				entity.getPresionArterial(), entity.getPulso(), entity.getTemperatura(), entity.getFrecuenciaCardiaca(),
				entity.getFrecuenciaRespiratoria(), entity.getPeso(), entity.getTalla(), entity.getMasa(),
				entity.getExamenClinico(), entity.getComplementoExamen());
	}
}
