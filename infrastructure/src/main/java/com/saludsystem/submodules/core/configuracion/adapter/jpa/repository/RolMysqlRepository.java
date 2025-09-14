package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.port.in.repository.RolRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.RoleJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.RolDboMapper;

@Component
public class RolMysqlRepository implements RolRepository
{
	private final RoleJpaRepository roleJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public RolMysqlRepository(RoleJpaRepository roleJpaRepository, AuthenticateUserPort authenticateUserPort)
	{
		this.roleJpaRepository = roleJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Rol save(Rol rol)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		RoleEntity entity = RolDboMapper.toEntity(rol, hospitalId);
		return RolDboMapper.toDomain(roleJpaRepository.save(entity));
	}

	@Override
	public Rol update(UUID uuid, Rol rol)
	{
		UUID hospitalId = authenticateUserPort.getHospitalId();
		RoleEntity entity = RolDboMapper.toEntity(rol, hospitalId);
		return RolDboMapper.toDomain(roleJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		roleJpaRepository.deleteById(uuid);
	}
}
