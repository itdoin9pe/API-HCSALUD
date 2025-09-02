package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.evolucion;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.NotaEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.NotaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.NotaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.NotaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.paciente.port.repository.evolucion.NotaRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NotaMysqlRepository implements NotaRepository {

    private final NotaJpaRepository notaJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public NotaMysqlRepository(NotaJpaRepository notaJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.notaJpaRepository = notaJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Nota save(Nota nota) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        NotaEntity entity = NotaDboMapper.toEntity(nota, userId, hospitalId);
        return NotaDboMapper.toDomain(notaJpaRepository.save(entity));
    }

    @Override
    public Nota update(Long id, Nota nota) {
        if (!notaJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(NotaConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        NotaEntity entity = NotaDboMapper.toEntity(nota, userId, hospitalId);
        return NotaDboMapper.toDomain(notaJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!notaJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(NotaConstant.ID_NOT_FOUND);
        }
        notaJpaRepository.deleteById(id);
    }

}
