package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.AntecedentesEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.AntecedenteJpaRespository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.AntecedenteDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.AntecedenteConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.AntecedenteRespository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class AntecedenteMysqlRepository implements AntecedenteRespository
{
	private final AntecedenteJpaRespository antecedenteJpaRespository;
	private final AuthenticateUserPort authenticateUserPort;

	public AntecedenteMysqlRepository(
		AntecedenteJpaRespository antecedenteJpaRespository,
		AuthenticateUserPort authenticateUserPort)
	{
		this.antecedenteJpaRespository = antecedenteJpaRespository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Antecedente save(Antecedente antecedente)
	{
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		AntecedentesEntity entity = AntecedenteDboMapper.toEntity(antecedente, userId, hospitalId);
		return AntecedenteDboMapper.toDomain(antecedenteJpaRespository.save(entity));
	}

	@Override
	public Antecedente update(UUID uuid, Antecedente antecedente)
	{
		if (!antecedenteJpaRespository.existsById(uuid))
		{
			throw new ResourceNotFoundException(AntecedenteConstant.ID_NOT_FOUND);
		}
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		AntecedentesEntity entity = AntecedenteDboMapper.toEntity(antecedente, userId, hospitalId);
		return AntecedenteDboMapper.toDomain(antecedenteJpaRespository.save(entity));
	}

	@Override
	public void delete(UUID uuid)
	{
		if (!antecedenteJpaRespository.existsById(uuid))
		{
			throw new ResourceNotFoundException(AntecedenteConstant.ID_NOT_FOUND);
		}
		antecedenteJpaRespository.deleteById(uuid);
	}
}
