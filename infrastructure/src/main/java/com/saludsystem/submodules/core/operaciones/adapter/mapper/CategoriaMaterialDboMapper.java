package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.CategoriaMatEntity;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;

public class CategoriaMaterialDboMapper
{
	public static CategoriaMatEntity toEntity(CategoriaMaterial model, UUID userId, UUID hospitalId)
	{
		CategoriaMatEntity entity = new CategoriaMatEntity();
		entity.setCategoriaMaterialId(model.getCategoriaMaterialId());
		entity.setNombre(model.getNombre());
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

	public static CategoriaMaterial toDomain(CategoriaMatEntity entity)
	{
		return new CategoriaMaterial(entity.getCategoriaMaterialId(), entity.getNombre(), entity.getDescripcion(),
				entity.getEstado());
	}
}
