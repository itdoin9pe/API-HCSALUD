package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.principal.adapter.entity.AseguradoraEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.AseguradoraJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.AseguradoraDboMapper;
import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AseguradoraMysqlRepository implements AseguradoraRepository {

    private final AseguradoraJpaRepository aseguradoraJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public AseguradoraMysqlRepository(AseguradoraJpaRepository aseguradoraJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.aseguradoraJpaRepository = aseguradoraJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Aseguradora save(Aseguradora aseguradora) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AseguradoraEntity entity = AseguradoraDboMapper.toEntity(aseguradora, userId, hospitalId);
        return AseguradoraDboMapper.toDomain(aseguradoraJpaRepository.save(entity));
    }

    @Override
    public Aseguradora update(UUID uuid, Aseguradora aseguradora) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AseguradoraEntity entity = AseguradoraDboMapper.toEntity(aseguradora, userId, hospitalId);
        return AseguradoraDboMapper.toDomain(aseguradoraJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        aseguradoraJpaRepository.deleteById(uuid);
    }
}
