package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.CuentaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.CuentaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.CuentaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.model.constant.CuentaConstant;
import com.saludsystem.submodules.mantenimiento.port.service.CuentaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaMysqlRepository implements CuentaRepository {

    private final CuentaJpaRepository cuentaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CuentaMysqlRepository(CuentaJpaRepository cuentaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.cuentaJpaRepository = cuentaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public Cuenta save(Cuenta cuenta) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CuentaEntity entity = CuentaDboMapper.toEntity(cuenta, userId, hospitalId);
        return CuentaDboMapper.toDomain(cuentaJpaRepository.save(entity));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public Cuenta update(UUID uuid, Cuenta cuenta) {
        if (!cuentaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CuentaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CuentaEntity entity = CuentaDboMapper.toEntity(cuenta, userId, hospitalId);
        return CuentaDboMapper.toDomain(cuentaJpaRepository.save(entity));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public void delete(UUID uuid) {
        if (!cuentaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CuentaConstant.ID_NOT_FOUND);
        }
        cuentaJpaRepository.deleteById(uuid);
    }
}
