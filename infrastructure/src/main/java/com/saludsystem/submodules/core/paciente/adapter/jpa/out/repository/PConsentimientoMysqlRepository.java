package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.PConsentimientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.PConsentimientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.PConsentimientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.PConsentimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.paciente.port.repository.PConsentimientoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class PConsentimientoMysqlRepository implements PConsentimientoRepository {

    private final PConsentimientoJpaRepository pConsentimientoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public PConsentimientoMysqlRepository(PConsentimientoJpaRepository pConsentimientoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.pConsentimientoJpaRepository = pConsentimientoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public PacienteConsentimiento save(PacienteConsentimiento pacienteConsentimiento) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        PConsentimientoEntity entity = PConsentimientoDboMapper.toEntity(pacienteConsentimiento, hospitalId, userId);
        return PConsentimientoDboMapper.toDomain(pConsentimientoJpaRepository.save(entity));
    }

    @Override
    public PacienteConsentimiento update(UUID uuid, PacienteConsentimiento pacienteConsentimiento) {
        if (!pConsentimientoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(PConsentimientoConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        PConsentimientoEntity entity = PConsentimientoDboMapper.toEntity(pacienteConsentimiento, hospitalId, userId);
        return PConsentimientoDboMapper.toDomain(pConsentimientoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!pConsentimientoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(PConsentimientoConstant.ID_NOT_FOUND);
        }
        pConsentimientoJpaRepository.existsById(uuid);
    }
}
