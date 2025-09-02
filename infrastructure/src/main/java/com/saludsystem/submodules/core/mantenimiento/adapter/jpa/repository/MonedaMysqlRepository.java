package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.MonedaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.MonedaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.MonedaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaMysqlRepository implements MonedaRepository {

    private final MonedaJpaRepository monedaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public MonedaMysqlRepository(MonedaJpaRepository monedaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.monedaJpaRepository = monedaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Moneda save(Moneda moneda) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MonedaEntity entity = MonedaDboMapper.toEntity(moneda, userId, hospitalId);
        return MonedaDboMapper.toDomain(monedaJpaRepository.save(entity));
    }

    @Override
    public Moneda update(UUID uuid, Moneda moneda) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        MonedaEntity entity = MonedaDboMapper.toEntity(moneda, userId, hospitalId);
        return MonedaDboMapper.toDomain(monedaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        monedaJpaRepository.deleteById(uuid);
    }
}
