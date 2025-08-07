package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioMedicoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.EstudioMedicoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.EstudioMedicoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioMedicoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.paciente.port.repository.EstudioMedicoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioMedicoMysqlRepository implements EstudioMedicoRepository {

    private final EstudioMedicoJpaRepository estudioMedicoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EstudioMedicoMysqlRepository(EstudioMedicoJpaRepository estudioMedicoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.estudioMedicoJpaRepository = estudioMedicoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public EstudioMedico save(EstudioMedico estudioMedico) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        EstudioMedicoEntity entity = EstudioMedicoDboMapper.toEntity(estudioMedico, hospitalId, userId);
        return EstudioMedicoDboMapper.toDomain(estudioMedicoJpaRepository.save(entity));
    }

    @Override
    public EstudioMedico update(Long id, EstudioMedico estudioMedico) {
        if (!estudioMedicoJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(EstudioMedicoConstant.ID_NOT_FOUND);
        }
        UUID hospitalId = authenticateUserPort.getHospitalId();
        UUID userId = authenticateUserPort.getUserId();
        EstudioMedicoEntity entity = EstudioMedicoDboMapper.toEntity(estudioMedico, hospitalId, userId);
        return EstudioMedicoDboMapper.toDomain(estudioMedicoJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!estudioMedicoJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(EstudioMedicoConstant.ID_NOT_FOUND);
        }
        estudioMedicoJpaRepository.deleteById(id);
    }
}
