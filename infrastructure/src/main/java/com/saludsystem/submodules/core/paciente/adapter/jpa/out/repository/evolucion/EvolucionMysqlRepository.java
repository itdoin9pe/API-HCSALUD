package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.evolucion;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.EvolucionEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.EvolucionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.EvolucionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.EvolucionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.port.repository.evolucion.EvolucionRepository;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EvolucionMysqlRepository implements EvolucionRepository {

    private final EvolucionJpaRepository evolucionJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EvolucionMysqlRepository(EvolucionJpaRepository evolucionJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.evolucionJpaRepository = evolucionJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Evolucion save(Evolucion evolucion) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EvolucionEntity entity = EvolucionDboMapper.toEntity(evolucion, userId, hospitalId);
        return EvolucionDboMapper.toDomain(evolucionJpaRepository.save(entity));
    }

    @Override
    public Evolucion update(UUID uuid, Evolucion evolucion) {
        if (!evolucionJpaRepository.existsById(uuid)) {
            throw new RequestRejectedException(EvolucionConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EvolucionEntity entity = EvolucionDboMapper.toEntity(evolucion, userId, hospitalId);
        return EvolucionDboMapper.toDomain(evolucionJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!evolucionJpaRepository.existsById(uuid)) {
            throw new RequestRejectedException(EvolucionConstant.ID_NOT_FOUND);
        }
        evolucionJpaRepository.deleteById(uuid);
    }
}
