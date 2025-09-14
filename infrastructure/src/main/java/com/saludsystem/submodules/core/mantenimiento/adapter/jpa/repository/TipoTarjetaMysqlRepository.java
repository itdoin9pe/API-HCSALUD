package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoTarjetaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoTarjetaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoTarjetaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

@Component
public class TipoTarjetaMysqlRepository implements TipoTarjetaRepository
{
	private final TipoTarjetaJpaRepository tipoTarjetaJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public TipoTarjetaMysqlRepository(
		TipoTarjetaJpaRepository tipoTarjetaJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.tipoTarjetaJpaRepository = tipoTarjetaJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public TipoTarjeta save(TipoTarjeta tipoTarjeta)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoTarjetaEntity entity = TipoTarjetaDboMapper.toEntity(tipoTarjeta, userId, hospitalId);
		return TipoTarjetaDboMapper.toDomain(tipoTarjetaJpaRepository.save(entity));
	}

	@Override
	public TipoTarjeta update(UUID uuid, TipoTarjeta tipoTarjeta)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoTarjetaEntity entity = TipoTarjetaDboMapper.toEntity(tipoTarjeta, userId, hospitalId);
		return TipoTarjetaDboMapper.toDomain(tipoTarjetaJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		tipoTarjetaJpaRepository.deleteById(uuid);
	}
}
