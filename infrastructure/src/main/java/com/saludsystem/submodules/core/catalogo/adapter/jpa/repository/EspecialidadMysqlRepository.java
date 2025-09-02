package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.EspecialidadJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.EspecialidadDboMapper;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.model.constant.EspecialidadConstant;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadMysqlRepository implements EspecialidadRepository {

    private final EspecialidadJpaRepository especialidadJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EspecialidadMysqlRepository(EspecialidadJpaRepository especialidadJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.especialidadJpaRepository = especialidadJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad, userId, hospitalId);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));
    }

    @Override
    public Especialidad update(UUID uuid, Especialidad especialidad) {
    	if (!especialidadJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(EspecialidadConstant.ID_NOT_FOUND);
		}
        UUID hospitalId = authenticateUserPort.getHospitalId();
    	UUID userId = authenticateUserPort.getUserId();
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad, hospitalId, userId);
        entity.setEspecialidadId(uuid);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
    	if (!especialidadJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(EspecialidadConstant.ID_NOT_FOUND);
		}
        especialidadJpaRepository.deleteById(uuid);
    }
}
