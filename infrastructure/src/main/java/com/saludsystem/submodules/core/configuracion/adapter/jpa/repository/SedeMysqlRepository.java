package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.model.constant.SedeConstant;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SedeJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.SedeDboMapper;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SedeMysqlRepository implements SedeRepository {

    private final SedeJpaRepository sedeJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public SedeMysqlRepository(SedeJpaRepository sedeJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.sedeJpaRepository = sedeJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Sede save(Sede sede) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        SedeEntity entity = SedeDboMapper.toEntity(sede, hospitalId, userId);
        return SedeDboMapper.toDomain(sedeJpaRepository.save(entity));
    }

    @Override
    public Sede update(UUID uuid, Sede sede) {
        if (!sedeJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(SedeConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        SedeEntity entity = SedeDboMapper.toEntity(sede, hospitalId, userId);
        entity.setSedeId(uuid);
        return SedeDboMapper.toDomain(sedeJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!sedeJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(SedeConstant.ID_NOT_FOUND);
        }
        sedeJpaRepository.deleteById(uuid);
    }
}
