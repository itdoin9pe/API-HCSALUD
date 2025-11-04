package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.TipoMaterialEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.TipoMaterialJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.TipoMaterialDboMapper;
import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.port.repository.TipoMaterialRepository;

@Component
public class TipoMaterialMysqlRepository implements TipoMaterialRepository
{
	private final TipoMaterialJpaRepository tipoMaterialJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public TipoMaterialMysqlRepository(
		TipoMaterialJpaRepository tipoMaterialJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.tipoMaterialJpaRepository = tipoMaterialJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public TipoMaterial save(TipoMaterial tipoMaterial)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoMaterialEntity entity = TipoMaterialDboMapper.toEntity(tipoMaterial, userId, hospitalId);
		return TipoMaterialDboMapper.toDomain(tipoMaterialJpaRepository.save(entity));
	}

	@Override
	public TipoMaterial update(UUID uuid, TipoMaterial tipoMaterial)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoMaterialEntity entity = TipoMaterialDboMapper.toEntity(tipoMaterial, userId, hospitalId);
		return TipoMaterialDboMapper.toDomain(tipoMaterialJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		tipoMaterialJpaRepository.deleteById(uuid);
	}
}
