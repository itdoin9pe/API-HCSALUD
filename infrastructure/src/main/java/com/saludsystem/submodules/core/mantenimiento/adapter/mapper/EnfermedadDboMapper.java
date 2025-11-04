package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.EnfermedadEntity;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;

public class EnfermedadDboMapper
{
	public static EnfermedadEntity toEntity(Enfermedad model, UUID userId, UUID hospitalId)
	{
		EnfermedadEntity entity = new EnfermedadEntity();
		entity.setEnfermedadId(model.getId());
		entity.setDescripcion(model.getDescripcion());
		entity.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Enfermedad toDomain(EnfermedadEntity entity)
	{
		return new Enfermedad(entity.getEnfermedadId(), entity.getDescripcion(), entity.getEstado());
	}
}
