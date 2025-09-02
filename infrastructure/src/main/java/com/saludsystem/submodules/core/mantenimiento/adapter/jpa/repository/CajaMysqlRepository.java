package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.CajaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.CajaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.CajaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaMysqlRepository implements CajaRepository {

    private final CajaJpaRepository cajaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CajaMysqlRepository(CajaJpaRepository cajaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.cajaJpaRepository = cajaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Caja save(Caja caja) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CajaEntity entity = CajaDboMapper.toEntity(caja, userId, hospitalId);
        return CajaDboMapper.toDomain(cajaJpaRepository.save(entity));
    }

    @Override
    public Caja update(UUID uuid, Caja caja) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CajaEntity entity = CajaDboMapper.toEntity(caja, userId, hospitalId);
        return CajaDboMapper.toDomain(cajaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        cajaJpaRepository.deleteById(uuid);
    }
}
