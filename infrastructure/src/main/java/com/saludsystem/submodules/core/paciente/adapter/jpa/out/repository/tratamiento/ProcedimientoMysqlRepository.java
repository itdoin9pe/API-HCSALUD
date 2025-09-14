package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.ProcedimientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.ProcedimientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.ProcedimientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.ProcedimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.ProcedimientoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ProcedimientoMysqlRepository implements ProcedimientoRepository
{
	private final ProcedimientoJpaRepository procedimientoJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public ProcedimientoMysqlRepository(
		ProcedimientoJpaRepository procedimientoJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.procedimientoJpaRepository = procedimientoJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Procedimiento save(Procedimiento procedimiento)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		ProcedimientoEntity entity = ProcedimientoDboMapper.toEntity(procedimiento, userId, hospitalId);
		return ProcedimientoDboMapper.toDomain(procedimientoJpaRepository.save(entity));
	}

	@Override
	public Procedimiento update(UUID uuid, Procedimiento procedimiento)
	{
		if (!procedimientoJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(ProcedimientoConstant.ID_NOT_FOUND);
		}
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		ProcedimientoEntity entity = ProcedimientoDboMapper.toEntity(procedimiento, userId, hospitalId);
		return ProcedimientoDboMapper.toDomain(procedimientoJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!procedimientoJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(ProcedimientoConstant.ID_NOT_FOUND);
		}
		procedimientoJpaRepository.deleteById(uuid);
	}
}
