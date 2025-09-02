package com.saludsystem.submodules.core.operaciones.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import com.saludsystem.submodules.core.operaciones.adapter.jpa.UnidadJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.UnidadDboMapper;
import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.port.repository.UnidadRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UnidadMysqlRepository implements UnidadRepository {

    private final UnidadJpaRepository unidadJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public UnidadMysqlRepository(UnidadJpaRepository unidadJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.unidadJpaRepository = unidadJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Unidad save(Unidad unidad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UnidadEntity entity = UnidadDboMapper.toEntity(unidad, userId, hospitalId);
        return UnidadDboMapper.toDomain(unidadJpaRepository.save(entity));
    }

    @Override
    public Unidad update(UUID uuid, Unidad unidad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UnidadEntity entity = UnidadDboMapper.toEntity(unidad, userId, hospitalId);
        return UnidadDboMapper.toDomain(unidadJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        unidadJpaRepository.deleteById(uuid);
    }

}
