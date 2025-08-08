package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.estadocuenta;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta.EPagoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.EPagoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.EPagoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EPagoConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EPagoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EPagoMysqlRepository implements EPagoRepository {

    private final EPagoJpaRepository ePagoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EPagoMysqlRepository(EPagoJpaRepository ePagoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.ePagoJpaRepository = ePagoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public EPago save(EPago ePago) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        EPagoEntity entity = EPagoDboMapper.toEntity(ePago, hospitalId, userId);
        return EPagoDboMapper.toDomain(ePagoJpaRepository.save(entity));
    }

    @Override
    public EPago update(UUID uuid, EPago ePago) {
        if (!ePagoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(EPagoConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        EPagoEntity entity = EPagoDboMapper.toEntity(ePago, hospitalId, userId);
        return EPagoDboMapper.toDomain(ePagoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!ePagoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(EPagoConstant.ID_NOT_FOUND);
        }
        ePagoJpaRepository.deleteById(uuid);
    }
}
