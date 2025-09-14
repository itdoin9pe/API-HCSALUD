package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoCitadoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

public class TipoCitadoDboMapper
{
	public static TipoCitadoEntity toEntity(TipoCitado model, UUID userId, UUID hospitalId)
	{
		TipoCitadoEntity e = new TipoCitadoEntity();
		e.setTipoCitadoId(model.getId());
		e.setNombre(model.getNombre());
		e.setColor(model.getColor());
		e.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		e.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		e.setHospital(hospitalEntity);

		return e;
	}

	public static TipoCitado toDomain(TipoCitadoEntity e)
	{
		return new TipoCitado(e.getTipoCitadoId(), e.getNombre(), e.getColor(), e.getEstado());
	}
}