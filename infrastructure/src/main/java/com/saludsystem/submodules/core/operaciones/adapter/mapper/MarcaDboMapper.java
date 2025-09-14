package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.MarcaEntity;
import com.saludsystem.submodules.operaciones.model.Marca;

public class MarcaDboMapper
{
	public static MarcaEntity toEntity(Marca model, UUID userId, UUID hospitalId)
	{
		MarcaEntity entity = new MarcaEntity();
		entity.setMarcaMaterialesId(model.getId());
		entity.setNombre(model.getNombre());
		entity.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Marca toDomain(MarcaEntity entity)
	{
		return new Marca(entity.getMarcaMaterialesId(), entity.getNombre(), entity.getEstado());
	}
}
