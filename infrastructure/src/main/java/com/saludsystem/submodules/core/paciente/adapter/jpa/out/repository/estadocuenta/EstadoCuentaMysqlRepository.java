package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.estadocuenta;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EstadoCuentaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.EstadoCuentaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.EstadoCuentaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EstadoCuentaConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EstadoCuentaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstadoCuentaMysqlRepository implements EstadoCuentaRepository {

    private final EstadoCuentaJpaRepository estadoCuentaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EstadoCuentaMysqlRepository(EstadoCuentaJpaRepository estadoCuentaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.estadoCuentaJpaRepository = estadoCuentaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public EstadoCuenta save(EstadoCuenta estadoCuenta) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstadoCuentaEntity entity = EstadoCuentaDboMapper.toEntity(estadoCuenta, userId, hospitalId);
        return EstadoCuentaDboMapper.toDomain(entity);
    }

    @Override
    public EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta) {
        if (!estadoCuentaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(EstadoCuentaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstadoCuentaEntity entity = EstadoCuentaDboMapper.toEntity(estadoCuenta, userId, hospitalId);
        return EstadoCuentaDboMapper.toDomain(entity);
    }

    @Override
    public void delete(UUID uuid) {
        if (!estadoCuentaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(EstadoCuentaConstant.ID_NOT_FOUND);
        }
        estadoCuentaJpaRepository.deleteById(uuid);
    }
}
