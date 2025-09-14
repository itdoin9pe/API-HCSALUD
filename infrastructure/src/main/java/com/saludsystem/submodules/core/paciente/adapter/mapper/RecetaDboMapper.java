package com.saludsystem.submodules.core.paciente.adapter.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.MedicamentoRecetadoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.RecetaEntity;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.model.entity.Receta;

public class RecetaDboMapper
{
	public static Receta toDomain(RecetaEntity entity)
	{
		if (entity == null)
		{
			return null;
		}
		return new Receta(entity.getPacienteRecetaId(), entity.getFecha(), entity.getDoctorEntity().getDoctorId(),
				entity.getPacienteEntity().getPacienteId(), entity.getObservaciones(), entity.getEstado(),
				toMedicamentoRecetadoDomainList(entity.getMedicamentosRecetados()));
	}

	public static RecetaEntity toEntity(Receta domain, UUID userId, UUID hospitalId)
	{
		if (domain == null)
		{
			return null;
		}
		RecetaEntity recetaEntity = new RecetaEntity();
		recetaEntity.setPacienteRecetaId(domain.getPacienteRecetaId());
		recetaEntity.setFecha(domain.getFecha());
		recetaEntity.setObservaciones(domain.getObservaciones());
		recetaEntity.setEstado(domain.getEstado());
		// DoctorEntity y PacienteEntity se asignan desde el servicio usando fetch/find
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		recetaEntity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		recetaEntity.setHospital(hospitalEntity);
		recetaEntity.setMedicamentosRecetados(
				toMedicamentoRecetadoEntityList(domain.getMedicamentosRecetados(), recetaEntity));
		return recetaEntity;
	}

	private static List<MedicamentoRecetado> toMedicamentoRecetadoDomainList(List<MedicamentoRecetadoEntity> entities)
	{
		if (entities == null)
		{
			return List.of();
		}
		return entities.stream()
				.map(e -> new MedicamentoRecetado(e.getId(), e.getRecetaEntity().getPacienteRecetaId(),
						e.getMedicamentoEntity().getMedicamentoId(), e.getDosis(), e.getFrecuencia(),
						e.getDuracionDias(), e.getIndicaciones()))
				.collect(Collectors.toList());
	}

	private static List<MedicamentoRecetadoEntity> toMedicamentoRecetadoEntityList(
		List<MedicamentoRecetado> domainList,
		RecetaEntity recetaEntity)
	{
		if (domainList == null)
		{
			return List.of();
		}
		return domainList.stream().map(d -> {
			MedicamentoRecetadoEntity entity = new MedicamentoRecetadoEntity();
			entity.setId(d.getId());
			entity.setDosis(d.getDosis());
			entity.setFrecuencia(d.getFrecuencia());
			entity.setDuracionDias(d.getDuracionDias());
			entity.setIndicaciones(d.getIndicaciones());
			entity.setRecetaEntity(recetaEntity);
			return entity;
		}).collect(Collectors.toList());
	}
}
