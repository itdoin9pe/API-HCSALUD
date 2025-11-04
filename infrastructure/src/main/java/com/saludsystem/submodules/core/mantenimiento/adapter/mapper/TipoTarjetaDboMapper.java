package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoTarjetaEntity;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;

public class TipoTarjetaDboMapper
{
	public static TipoTarjetaEntity toEntity(TipoTarjeta model, UUID userId, UUID hospitalId)
	{
		TipoTarjetaEntity entity = new TipoTarjetaEntity();
		entity.setTipoTarjetaId(model.getTipoTarjetaId());
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

	public static TipoTarjeta toDomain(TipoTarjetaEntity entity)
	{
		return new TipoTarjeta(entity.getTipoTarjetaId(), entity.getDescripcion(), entity.getEstado());
	}
}
