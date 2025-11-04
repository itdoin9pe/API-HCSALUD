package com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.CostoTratamientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.PlanTratamientoEntity;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;

public class CostoTratamientoDboMapper
{
	public static CostoTratamientoEntity toEntity(CostoTratamiento model, UUID userId, UUID hospitalId)
	{
		CostoTratamientoEntity entity = new CostoTratamientoEntity();
		entity.setPacienteCostoTratamientoId(model.getPacienteCostoTratamientoId());
		entity.setConcepto(model.getConcepto());
		entity.setMonto(model.getMonto());
		entity.setMoneda(model.getMoneda());
		entity.setPagado(model.isPagado());
		// Paciente
		var pacienteEntity = new PacienteEntity();
		pacienteEntity.setPacienteId(model.getPacienteId());
		entity.setPacienteEntity(pacienteEntity);
		// Plan de tratamiento
		var planTratamientoEntity = new PlanTratamientoEntity();
		planTratamientoEntity.setPacientePlanTratamientoId(model.getPlanTratamientoId());
		entity.setPlanTratamientoEntity(planTratamientoEntity);
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

	public static CostoTratamiento toDomain(CostoTratamientoEntity entity)
	{
		return new CostoTratamiento(entity.getPacienteCostoTratamientoId(), entity.getPacienteEntity().getPacienteId(),
				entity.getPlanTratamientoEntity().getPacientePlanTratamientoId(), entity.getConcepto(),
				entity.getMonto(), entity.getMoneda(), entity.isPagado());
	}
}
