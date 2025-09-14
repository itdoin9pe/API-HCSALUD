package com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.AltaMedicaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.EvolucionEntity;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;

public class AltaMedicaDboMapper
{
	public static AltaMedicaEntity toEntity(AltaMedica model, UUID userId, UUID hospitalId)
	{
		AltaMedicaEntity entity = new AltaMedicaEntity();
		entity.setId(model.getId());
		entity.setFecha(model.getFecha());
		entity.setResumenFinal(model.getResumenFinal());
		// Relación con Evolución
		if (model.getPacienteEvolucionId() != null)
		{
			EvolucionEntity evolucionEntity = new EvolucionEntity();
			evolucionEntity.setPacienteEvolucionId(model.getPacienteEvolucionId());
			entity.setEvolucionEntity(evolucionEntity);
		}
		// Auditoría
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static AltaMedica toDomain(AltaMedicaEntity entity)
	{
		return new AltaMedica(entity.getId(), entity.getFecha(), entity.getResumenFinal(),
				entity.getEvolucionEntity() != null ? entity.getEvolucionEntity().getPacienteEvolucionId() : null);
	}
}
