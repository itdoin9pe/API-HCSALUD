package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.EstudioResultadoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.EstudioResultadoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.EstudioResultadoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioResultadoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.paciente.port.repository.EstudioResultadoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioResultadoMysqlRepository implements EstudioResultadoRepository {

    private final EstudioResultadoJpaRepository estudioResultadoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EstudioResultadoMysqlRepository(EstudioResultadoJpaRepository estudioResultadoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.estudioResultadoJpaRepository = estudioResultadoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public EstudioResultado save(EstudioResultado estudioResultado) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstudioResultadoEntity entity = EstudioResultadoDboMapper.toEntity(estudioResultado, userId, hospitalId);
        return EstudioResultadoDboMapper.toDomain(estudioResultadoJpaRepository.save(entity));
    }

    @Override
    public EstudioResultado update(Long id, EstudioResultado estudioResultado) {
        if (!estudioResultadoJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(EstudioResultadoConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EstudioResultadoEntity entity = EstudioResultadoDboMapper.toEntity(estudioResultado, userId, hospitalId);
        return EstudioResultadoDboMapper.toDomain(estudioResultadoJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!estudioResultadoJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(EstudioResultadoConstant.ID_NOT_FOUND);
        }
        estudioResultadoJpaRepository.deleteById(id);
    }

}
