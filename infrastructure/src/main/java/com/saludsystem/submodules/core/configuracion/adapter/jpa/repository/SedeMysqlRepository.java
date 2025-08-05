package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SedeJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.SedeDboMapper;
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
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        SedeEntity entity = SedeDboMapper.toEntity(sede, hospitalId, userId);
        return SedeDboMapper.toDomain(sedeJpaRepository.save(entity));
    }

    @Override
    public Sede update(UUID uuid, Sede sede) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        SedeEntity entity = SedeDboMapper.toEntity(sede, hospitalId, userId);
        return SedeDboMapper.toDomain(sedeJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        sedeJpaRepository.deleteById(uuid);
    }
}
