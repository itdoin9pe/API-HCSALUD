package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.RecetaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.RecetaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.RecetaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.paciente.port.repository.RecetaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RecetaMysqlRepository implements RecetaRepository {

    private final RecetaJpaRepository recetaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public RecetaMysqlRepository(RecetaJpaRepository recetaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.recetaJpaRepository = recetaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Receta save(Receta receta) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        RecetaEntity entity = RecetaDboMapper.toEntity(receta, hospitalId, userId);
        return RecetaDboMapper.toDomain(recetaJpaRepository.save(entity));
    }

    @Override
    public Receta update(UUID uuid, Receta receta) {
        if (!recetaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(RecetaConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        RecetaEntity entity = RecetaDboMapper.toEntity(receta, hospitalId, userId);
        return RecetaDboMapper.toDomain(recetaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!recetaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(RecetaConstant.ID_NOT_FOUND);
        }
        recetaJpaRepository.deleteById(uuid);
    }

}
