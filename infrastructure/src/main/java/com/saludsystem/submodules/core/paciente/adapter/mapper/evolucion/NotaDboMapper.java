package com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.EvolucionEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.NotaEntity;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

public class NotaDboMapper
{
	public static NotaEntity toEntity(Nota model, UUID userId, UUID hospitalId)
	{
		NotaEntity entity = new NotaEntity();
		entity.setId(model.getId());
		entity.setFecha(model.getFecha());
		entity.setTipo(model.getTipo());
		entity.setContenido(model.getContenido());
		if (model.getPacienteEvolucion() != null)
		{
			EvolucionEntity evolucionEntity = new EvolucionEntity();
			evolucionEntity.setPacienteEvolucionId(model.getPacienteEvolucion());
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

	public static Nota toDomain(NotaEntity entity)
	{
		return new Nota(entity.getId(), entity.getFecha(), entity.getTipo(), entity.getContenido(),
				entity.getEvolucionEntity() != null ? entity.getEvolucionEntity().getPacienteEvolucionId() : null);
	}
}
