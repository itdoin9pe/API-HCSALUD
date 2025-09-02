package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.principal.adapter.entity.EstudioEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.EstudioJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.EstudioDboMapper;
import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioMysqlRepository implements EstudioRepository {

    private final EstudioJpaRepository estudioJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EstudioMysqlRepository(EstudioJpaRepository estudioJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.estudioJpaRepository = estudioJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Estudio save(Estudio estudio) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstudioEntity entity = EstudioDboMapper.toEntity(estudio, userId, hospitalId);
        return EstudioDboMapper.toDomain(estudioJpaRepository.save(entity));
    }

    @Override
    public Estudio update(UUID uuid, Estudio estudio) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstudioEntity entity = EstudioDboMapper.toEntity(estudio, userId, hospitalId);
        return EstudioDboMapper.toDomain(estudioJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        estudioJpaRepository.deleteById(uuid);
    }
}
