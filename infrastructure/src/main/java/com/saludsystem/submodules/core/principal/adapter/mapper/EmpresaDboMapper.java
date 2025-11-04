package com.saludsystem.submodules.core.principal.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.EmpresaEntity;
import com.saludsystem.submodules.principal.model.Empresa;

public class EmpresaDboMapper
{
	public static EmpresaEntity toEntity(Empresa model, UUID userId, UUID hospitalId)
	{
		EmpresaEntity entity = new EmpresaEntity();
		entity.setEmpresaId(model.getEmpresaId());
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

	public static Empresa toDomain(EmpresaEntity entity)
	{
		return new Empresa(entity.getEmpresaId(), entity.getDescripcion(), entity.getEstado());
	}
}
