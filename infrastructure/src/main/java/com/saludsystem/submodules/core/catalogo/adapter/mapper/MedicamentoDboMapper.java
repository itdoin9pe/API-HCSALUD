package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedicamentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

public class MedicamentoDboMapper
{
	public static MedicamentoEntity toEntity(Medicamento model, UUID userId, UUID hospitalId)
	{
		MedicamentoEntity e = new MedicamentoEntity();
		e.setNombre(model.getNombre());
		e.setFormaFarmaceutica(model.getFormaFarmaceutica());
		e.setConcentracion(model.getConcentracion());
		e.setContenido(model.getContenido());
		e.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		e.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		e.setHospital(hospitalEntity);

		return e;
	}

	public static Medicamento toDomain(MedicamentoEntity e)
	{
		return new Medicamento(e.getMedicamentoId(), e.getNombre(), e.getFormaFarmaceutica(), e.getConcentracion(),
				e.getContenido(), e.getEstado());
	}
}