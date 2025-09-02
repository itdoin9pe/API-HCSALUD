package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.PacienteJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.PacienteDboMapper;
import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteMysqlRepository implements PacienteRepository {

    private final PacienteJpaRepository pacienteJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public PacienteMysqlRepository(PacienteJpaRepository pacienteJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.pacienteJpaRepository = pacienteJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Paciente save(Paciente paciente) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        PacienteEntity entity = PacienteDboMapper.toEntity(paciente, hospitalId, userId);
        return PacienteDboMapper.toDomain(pacienteJpaRepository.save(entity));
    }

    @Override
    public Paciente update(UUID uuid, Paciente paciente) {
        if (!pacienteJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(PacienteConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        PacienteEntity entity = PacienteDboMapper.toEntity(paciente, hospitalId, userId);
        return PacienteDboMapper.toDomain(pacienteJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!pacienteJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(PacienteConstant.ID_NOT_FOUND);
        }
        pacienteJpaRepository.deleteById(uuid);
    }

}
