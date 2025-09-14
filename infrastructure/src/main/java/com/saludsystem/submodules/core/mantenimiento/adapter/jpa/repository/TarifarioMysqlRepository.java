package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TarifarioEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TarifarioJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TarifarioDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

@Component
public class TarifarioMysqlRepository implements TarifarioRepository
{
	private final TarifarioJpaRepository tarifarioJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public TarifarioMysqlRepository(
		TarifarioJpaRepository tarifarioJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.tarifarioJpaRepository = tarifarioJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Tarifario save(Tarifario tarifario)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TarifarioEntity entity = TarifarioDboMapper.toEntity(tarifario, userId, hospitalId);
		return TarifarioDboMapper.toDomain(tarifarioJpaRepository.save(entity));
	}

	@Override
	public Tarifario update(UUID uuid, Tarifario tarifario)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TarifarioEntity entity = TarifarioDboMapper.toEntity(tarifario, userId, hospitalId);
		return TarifarioDboMapper.toDomain(tarifarioJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		tarifarioJpaRepository.deleteById(uuid);
	}
}
