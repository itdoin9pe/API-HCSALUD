package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.DiagnosticoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.DiagnosticoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.DiagnosticoDboMapper;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.paciente.port.repository.DiagnosticoRepository;

@Component
public class DiagnosticoMysqlRepository implements DiagnosticoRepository {

	private final DiagnosticoJpaRepository diagnosticoJpaRepository;
	private final AuthenticateUserPort authenticateUserPort;
	
	/**
	 * @param diagnosticoJpaRepository
	 * @param authenticateUserPort
	 */
	public DiagnosticoMysqlRepository(DiagnosticoJpaRepository diagnosticoJpaRepository,
			AuthenticateUserPort authenticateUserPort) {
		this.diagnosticoJpaRepository = diagnosticoJpaRepository;
		this.authenticateUserPort = authenticateUserPort;
	}

	@Override
	public Diagnostico save(Diagnostico diagnostico) {
		// TODO Auto-generated method stub
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		DiagnosticoEntity entity = DiagnosticoDboMapper.toEntity(diagnostico, userId, hospitalId);
		return DiagnosticoDboMapper.toDomain(entity);
	}

	@Override
	public Diagnostico update(UUID uuid, Diagnostico diagnostico) {
		// TODO Auto-generated method stub
		UUID userId = authenticateUserPort.getUserId();
		UUID hospitalId = authenticateUserPort.getHospitalId();
		DiagnosticoEntity entity = DiagnosticoDboMapper.toEntity(diagnostico, userId, hospitalId);
		return DiagnosticoDboMapper.toDomain(entity);
	}

	@Override
	public void delete(UUID uuid) {
		// TODO Auto-generated method stub
		diagnosticoJpaRepository.deleteById(uuid);
	}
}
