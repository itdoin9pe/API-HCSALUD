package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoPagoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoPagoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoMysqlRepository implements TipoPagoRepository {

    private final TipoPagoJpaRepository tipoPagoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public TipoPagoMysqlRepository(TipoPagoJpaRepository tipoPagoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.tipoPagoJpaRepository = tipoPagoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public TipoPago save(TipoPago tipoPago) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        TipoPagoEntity entity = TipoPagoDboMapper.toEntity(tipoPago, userId, hospitalId);
        return TipoPagoDboMapper.toDomain(tipoPagoJpaRepository.save(entity));
    }

    @Override
    public TipoPago update(UUID uuid, TipoPago tipoPago) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        TipoPagoEntity entity = TipoPagoDboMapper.toEntity(tipoPago, userId, hospitalId);
        return TipoPagoDboMapper.toDomain(tipoPagoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        tipoPagoJpaRepository.deleteById(uuid);
    }
}
