package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.evolucion;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.AltaMedicaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.AltaMedicaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.AltaMedicaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.AltaMedicaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.paciente.port.repository.evolucion.AltaMedicaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AltaMedicaMysqlRepository implements AltaMedicaRepository {

    private final AltaMedicaJpaRepository altaMedicaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public AltaMedicaMysqlRepository(AltaMedicaJpaRepository altaMedicaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.altaMedicaJpaRepository = altaMedicaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public AltaMedica save(AltaMedica altaMedica) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AltaMedicaEntity entity = AltaMedicaDboMapper.toEntity(altaMedica, userId, hospitalId);
        return AltaMedicaDboMapper.toDomain(altaMedicaJpaRepository.save(entity));
    }

    @Override
    public AltaMedica update(Long id, AltaMedica altaMedica) {
        if (!altaMedicaJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(AltaMedicaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        AltaMedicaEntity entity = AltaMedicaDboMapper.toEntity(altaMedica, userId, hospitalId);
        return AltaMedicaDboMapper.toDomain(altaMedicaJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!altaMedicaJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(AltaMedicaConstant.ID_NOT_FOUND);
        }
        altaMedicaJpaRepository.deleteById(id);
    }

}
