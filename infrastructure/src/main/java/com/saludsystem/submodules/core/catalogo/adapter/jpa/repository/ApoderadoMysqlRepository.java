package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.model.constant.ApoderadoConstant;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ApoderadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ApoderadoDboMapper;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ApoderadoMysqlRepository implements ApoderadoRepository
{
	private final ApoderadoJpaRepository jpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public ApoderadoMysqlRepository(ApoderadoJpaRepository jpaRepository, AuthenticateUserPort authenticateUserPort)
	{
		this.jpaRepository = jpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Apoderado save(Apoderado apoderado)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado, hospitalId, userId);
		return ApoderadoDboMapper.toDomain(jpaRepository.save(entity));
	}

	@Override
	public Apoderado update(UUID uuid, Apoderado apoderado)
	{
		if (!jpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(ApoderadoConstant.ID_NOT_FOUND);
		}
		UUID hospitalId = authenticateUserPort.getHospitalId();
		UUID userId = authenticateUserPort.getUserId();
		ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado, hospitalId, userId);
		entity.setApoderadoId(uuid);
		return ApoderadoDboMapper.toDomain(jpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!jpaRepository.existsById(uuid))
		{
			throw new ResourceNotFoundException(ApoderadoConstant.ID_NOT_FOUND);
		}
		jpaRepository.deleteById(uuid);
	}
}
