package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.historialclinico;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ExploracionFisicaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.ExploracionFisicaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.ExploracionFisicaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ExploracionConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ExploracionFisicaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExploracionFisicaMysqlRepository implements ExploracionFisicaRepository {

    private final ExploracionFisicaJpaRepository exploracionFisicaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public ExploracionFisicaMysqlRepository(ExploracionFisicaJpaRepository exploracionFisicaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.exploracionFisicaJpaRepository = exploracionFisicaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public ExploracionFisica save(ExploracionFisica exploracionFisica) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ExploracionFisicaEntity entity = ExploracionFisicaDboMapper.toEntity(exploracionFisica, userId, hospitalId);
        return ExploracionFisicaDboMapper.toDomain(exploracionFisicaJpaRepository.save(entity));
    }

    @Override
    public ExploracionFisica update(UUID uuid, ExploracionFisica exploracionFisica) {
        if (!exploracionFisicaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(ExploracionConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        ExploracionFisicaEntity entity = ExploracionFisicaDboMapper.toEntity(exploracionFisica, userId, hospitalId);
        return ExploracionFisicaDboMapper.toDomain(exploracionFisicaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!exploracionFisicaJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(ExploracionConstant.ID_NOT_FOUND);
        }
        exploracionFisicaJpaRepository.deleteById(uuid);
    }

}
