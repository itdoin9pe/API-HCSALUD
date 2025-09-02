package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.interconsulta;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.interconsulta.InterconsultaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta.InterconsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta.InterconsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InterconsultaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterconsultaMysqlRepository implements InterconsultaRepository {

    private final InterconsultaJpaRepository interconsultaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public InterconsultaMysqlRepository(InterconsultaJpaRepository interconsultaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.interconsultaJpaRepository = interconsultaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Interconsulta save(Interconsulta interconsulta) {
        UUID hospitald = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        InterconsultaEntity entity = InterconsultaDboMapper.toEntity(interconsulta, hospitald, userId);
        return InterconsultaDboMapper.toDomain(interconsultaJpaRepository.save(entity));
    }

    @Override
    public Interconsulta update(UUID uuid, Interconsulta interconsulta) {
        if (!interconsultaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(InterconsultaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitald = authenticateUserPort.getHospitalId();
        InterconsultaEntity entity = InterconsultaDboMapper.toEntity(interconsulta, userId, hospitald);
        return InterconsultaDboMapper.toDomain(interconsultaJpaRepository.save(entity));
    }

    @Override
    public void execute(UUID uuid) {
        if (!interconsultaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(InterconsultaConstant.ID_NOT_FOUND);
        }
        interconsultaJpaRepository.deleteById(uuid);
    }

}
