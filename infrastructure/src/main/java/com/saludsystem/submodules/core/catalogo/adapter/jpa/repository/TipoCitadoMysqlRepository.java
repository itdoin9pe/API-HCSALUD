package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoCitadoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.TipoCitadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.TipoCitadoDboMapper;

@Component
public class TipoCitadoMysqlRepository implements TipoCitadoRepository
{
	private final TipoCitadoJpaRepository tipoCitadoJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public TipoCitadoMysqlRepository(
		TipoCitadoJpaRepository tipoCitadoJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.tipoCitadoJpaRepository = tipoCitadoJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public TipoCitado save(TipoCitado tipoCitado)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoCitadoEntity entity = TipoCitadoDboMapper.toEntity(tipoCitado, userId, hospitalId);
		return TipoCitadoDboMapper.toDomain(tipoCitadoJpaRepository.save(entity));
	}

	@Override
	public TipoCitado update(UUID uuid, TipoCitado tipoCitado)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoCitadoEntity entity = TipoCitadoDboMapper.toEntity(tipoCitado, userId, hospitalId);
		return TipoCitadoDboMapper.toDomain(tipoCitadoJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		tipoCitadoJpaRepository.deleteById(uuid);
	}
}
