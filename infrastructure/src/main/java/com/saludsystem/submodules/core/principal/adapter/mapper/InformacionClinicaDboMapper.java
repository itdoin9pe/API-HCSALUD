package com.saludsystem.submodules.core.principal.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.InformacionClinicaEntity;
import com.saludsystem.submodules.principal.model.InformacionClinica;

public class InformacionClinicaDboMapper
{
	public static InformacionClinicaEntity toEntity(InformacionClinica model, UUID userId, UUID hospitalId)
	{
		InformacionClinicaEntity entity = new InformacionClinicaEntity();
		entity.setInformacionClinicaId(model.getId());
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

	public static InformacionClinica toDomain(InformacionClinicaEntity entity)
	{
		return new InformacionClinica(entity.getInformacionClinicaId(), entity.getNombre(), entity.getEstado());
	}
}
