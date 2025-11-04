package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.TipoConceptoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.TipoConceptoDboMapper;

@Component
public class TipoConceptoMysqlRepository implements TipoConceptoRepository
{
	private final TipoConceptoJpaRepository tipoConceptoJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;

	public TipoConceptoMysqlRepository(
		TipoConceptoJpaRepository tipoConceptoJpaRepository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.tipoConceptoJpaRepository = tipoConceptoJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public TipoConcepto save(TipoConcepto tipoConcepto)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoConceptoEntity entity = TipoConceptoDboMapper.toEntity(tipoConcepto, userId, hospitalId);
		return TipoConceptoDboMapper.toDomain(tipoConceptoJpaRepository.save(entity));
	}

	@Override
	public TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		TipoConceptoEntity entity = TipoConceptoDboMapper.toEntity(tipoConcepto, userId, hospitalId);
		return TipoConceptoDboMapper.toDomain(tipoConceptoJpaRepository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		tipoConceptoJpaRepository.deleteById(uuid);
	}
}
