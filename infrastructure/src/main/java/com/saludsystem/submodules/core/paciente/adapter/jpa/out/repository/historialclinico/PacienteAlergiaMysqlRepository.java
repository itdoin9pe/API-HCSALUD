package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.PacienteAlergiaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.PacienteAlergiaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.PacienteAlergiaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.PacienteAlergiaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.PacienteAlergiaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PacienteAlergiaMysqlRepository implements PacienteAlergiaRepository
{
	private final PacienteAlergiaJpaRepository pacienteAlergiaJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public PacienteAlergiaMysqlRepository(
		PacienteAlergiaJpaRepository pacienteAlergiaJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.pacienteAlergiaJpaRepository = pacienteAlergiaJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public PacienteAlergia save(PacienteAlergia pacienteAlergia)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		PacienteAlergiaEntity entity = PacienteAlergiaDboMapper.toEntity(pacienteAlergia, userId, hospitalId);
		return PacienteAlergiaDboMapper.toDomain(pacienteAlergiaJpaRepository.save(entity));
	}

	@Override
	public PacienteAlergia update(UUID uuid, PacienteAlergia pacienteAlergia)
	{
		if (!pacienteAlergiaJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(PacienteAlergiaConstant.ID_NOT_FOUND);
		}
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		PacienteAlergiaEntity entity = PacienteAlergiaDboMapper.toEntity(pacienteAlergia, userId, hospitalId);
		return PacienteAlergiaDboMapper.toDomain(pacienteAlergiaJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!pacienteAlergiaJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(PacienteAlergiaConstant.ID_NOT_FOUND);
		}
		pacienteAlergiaJpaRepository.deleteById(uuid);
	}
}
