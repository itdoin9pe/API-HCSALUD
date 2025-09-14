package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.interconsulta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InformeInterconsultaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta.InformeInterconsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta.InformeInterconsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InformeInterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InformeInterconsultaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class InformeInterconsultaMysqlRepository implements InformeInterconsultaRepository
{
	private final InformeInterconsultaJpaRepository informeInterconsultaJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public InformeInterconsultaMysqlRepository(
		InformeInterconsultaJpaRepository informeInterconsultaJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.informeInterconsultaJpaRepository = informeInterconsultaJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public InformeInterconsulta save(InformeInterconsulta informeInterconsulta)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		InformeInterconsultaEntity entity = InformeInterconsultaDboMapper.toEntity(informeInterconsulta, hospitalId,
				userId);
		return InformeInterconsultaDboMapper.toDomain(informeInterconsultaJpaRepository.save(entity));
	}

	@Override
	public InformeInterconsulta update(UUID uuid, InformeInterconsulta informeInterconsulta)
	{
		if (!informeInterconsultaJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(InformeInterconsultaConstant.ID_NOT_FOUND);
		}
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		InformeInterconsultaEntity entity = InformeInterconsultaDboMapper.toEntity(informeInterconsulta, hospitalId,
				userId);
		return InformeInterconsultaDboMapper.toDomain(informeInterconsultaJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!informeInterconsultaJpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(InformeInterconsultaConstant.ID_NOT_FOUND);
		}
		informeInterconsultaJpaRepository.deleteById(uuid);
	}
}
