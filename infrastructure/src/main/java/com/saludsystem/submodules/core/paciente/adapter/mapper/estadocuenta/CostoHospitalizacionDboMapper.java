package com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.CostoHospitalizacionEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;

public class CostoHospitalizacionDboMapper
{
	public static CostoHospitalizacionEntity toEntity(CostoHospitalizacion model, UUID hospitalId, UUID userId)
	{
		CostoHospitalizacionEntity entity = new CostoHospitalizacionEntity();
		entity.setPec_costoHospitalizacionId(model.getPec_costoHospitalizacionId());

		EstadoCuentaEntity estadoCuenta = new EstadoCuentaEntity();
		estadoCuenta.setPec_estadoCuentaId(model.getEstadoCuentaId());
		entity.setEstadoCuentaEntity(estadoCuenta);

		PacienteEntity paciente = new PacienteEntity();
		paciente.setPacienteId(model.getPacienteId());
		entity.setPacienteEntity(paciente);

		entity.setFechaIngreso(model.getFechaIngreso());
		entity.setFechaAlta(model.getFechaAlta());
		entity.setTipoHabitacion(model.getTipoHabitacion());
		entity.setCostoPorDia(model.getCostoPorDia());
		entity.setCantidadDias(model.getCantidadDias());
		entity.setTotalCosto(model.getTotalCosto());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static CostoHospitalizacion toDomain(CostoHospitalizacionEntity entity)
	{
		return new CostoHospitalizacion(entity.getPec_costoHospitalizacionId(),
				entity.getEstadoCuentaEntity().getPec_estadoCuentaId(), entity.getPacienteEntity().getPacienteId(),
				entity.getFechaIngreso(), entity.getFechaAlta(), entity.getTipoHabitacion(), entity.getCostoPorDia(),
				entity.getCantidadDias(), entity.getTotalCosto());
	}
}
