package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoGastoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.TipoGastoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.TipoGastoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoMysqlRepository implements TipoGastoRepository {

    private final TipoGastoJpaRepository tipoGastoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public TipoGastoMysqlRepository(TipoGastoJpaRepository tipoGastoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.tipoGastoJpaRepository = tipoGastoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public TipoGasto save(TipoGasto tipoGasto) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        TipoGastoEntity entity = TipoGastoDboMapper.toEntity(tipoGasto, userId, hospitalId);
        return TipoGastoDboMapper.toDomain(tipoGastoJpaRepository.save(entity));
    }

    @Override
    public TipoGasto update(UUID uuid, TipoGasto tipoGasto) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        TipoGastoEntity entity = TipoGastoDboMapper.toEntity(tipoGasto, userId, hospitalId);
        return TipoGastoDboMapper.toDomain(tipoGastoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        tipoGastoJpaRepository.deleteById(uuid);
    }
}
