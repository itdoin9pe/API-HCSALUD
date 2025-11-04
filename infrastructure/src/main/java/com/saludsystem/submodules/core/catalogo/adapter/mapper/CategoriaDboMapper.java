package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

public class CategoriaDboMapper
{
	public static CategoriaEntity toEntity(Categoria model, UUID userId, UUID hospitalId)
	{
		CategoriaEntity e = new CategoriaEntity();
		e.setCategoriaId(model.getId());
		e.setNombre(model.getNombre());
		e.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		e.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		e.setHospital(hospitalEntity);
		return e;
	}

	public static Categoria toDomain(CategoriaEntity e)
	{
		return new Categoria(e.getCategoriaId(), e.getNombre(), e.getEstado());
	}
}