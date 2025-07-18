package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ApoderadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ApoderadoDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoMysqlRepository implements ApoderadoRepository {

    private final ApoderadoJpaRepository jpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ApoderadoMysqlRepository(ApoderadoJpaRepository jpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.jpaRepository = jpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado, userId, hospitalId);
        return ApoderadoDboMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Apoderado update(UUID uuid, Apoderado apoderado) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado, userId, hospitalId);
        return ApoderadoDboMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        jpaRepository.deleteById(uuid);
    }
}
