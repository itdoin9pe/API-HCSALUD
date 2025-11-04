package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.PlanTratamientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.PlanTratamientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.PlanTratamientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.PlanTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.PlanTratamientoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PlanTratamientoMysqlRepository implements PlanTratamientoRepository
{
	private final PlanTratamientoJpaRepository planTratamientoJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public PlanTratamientoMysqlRepository(
		PlanTratamientoJpaRepository planTratamientoJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.planTratamientoJpaRepository = planTratamientoJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public PlanTratamiento save(PlanTratamiento planTratamiento)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		PlanTratamientoEntity entity = PlanTratamientoDboMapper.toEntity(planTratamiento, userId, hospitalId);
		return PlanTratamientoDboMapper.toDomain(planTratamientoJpaRepository.save(entity));
	}

	@Override
	public PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento)
	{
		if (!planTratamientoJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(PlanTratamientoConstant.ID_NOT_FOUND);
		}
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		PlanTratamientoEntity entity = PlanTratamientoDboMapper.toEntity(planTratamiento, userId, hospitalId);
		return PlanTratamientoDboMapper.toDomain(planTratamientoJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!planTratamientoJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(PlanTratamientoConstant.ID_NOT_FOUND);
		}
		planTratamientoJpaRepository.deleteById(uuid);
	}
}
