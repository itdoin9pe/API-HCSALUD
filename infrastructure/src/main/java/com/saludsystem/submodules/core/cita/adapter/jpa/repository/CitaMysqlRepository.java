package com.saludsystem.submodules.core.cita.adapter.jpa.repository;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.cita.adapter.entity.CitaEntity;
import com.saludsystem.submodules.core.cita.adapter.jpa.CitaJpaRepository;
import com.saludsystem.submodules.core.cita.adapter.mapper.CitaDboMapper;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaMysqlRepository implements CitaRepository {

    private final CitaJpaRepository citaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CitaMysqlRepository(CitaJpaRepository citaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.citaJpaRepository = citaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Cita save(Cita cita) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CitaEntity entity = CitaDboMapper.toEntity(cita, userId, hospitalId);
        return CitaDboMapper.toDomain(citaJpaRepository.save(entity));
    }

    @Override
    public Cita update(UUID uuid, Cita cita) {
        if (!citaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CitaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CitaEntity entity = CitaDboMapper.toEntity(cita, userId, hospitalId);
        return CitaDboMapper.toDomain(citaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!citaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CitaConstant.ID_NOT_FOUND);
        }
        citaJpaRepository.deleteById(uuid);
    }
}
