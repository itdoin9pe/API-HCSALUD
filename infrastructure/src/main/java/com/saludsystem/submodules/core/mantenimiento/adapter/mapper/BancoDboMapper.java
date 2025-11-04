package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.BancoEntity;
import com.saludsystem.submodules.mantenimiento.model.Banco;

public class BancoDboMapper
{
	public static BancoEntity toEntity(Banco model, UUID userId, UUID hospitalId)
	{
		BancoEntity entity = new BancoEntity();
		entity.setBancoId(model.getId());
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

	public static Banco toDomain(BancoEntity entity)
	{
		return new Banco(entity.getBancoId(), entity.getDescripcion(), entity.getEstado());
	}
}
