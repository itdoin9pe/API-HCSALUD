package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.evolucion;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.CambioCondicionEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.CambioCondicionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.CambioCondicionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.CambioCondicionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.port.repository.evolucion.CambioCondicionRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CambioCondicionMysqlRepository implements CambioCondicionRepository {

    private final CambioCondicionJpaRepository cambioCondicionJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CambioCondicionMysqlRepository(CambioCondicionJpaRepository cambioCondicionJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.cambioCondicionJpaRepository = cambioCondicionJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public CambioCondicion save(CambioCondicion cambioCondicion) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CambioCondicionEntity entity = CambioCondicionDboMapper.toEntity(cambioCondicion, userId, hospitalId);
        return CambioCondicionDboMapper.toDomain(cambioCondicionJpaRepository.save(entity));
    }

    @Override
    public CambioCondicion update(Long id, CambioCondicion cambioCondicion) {
        if (!cambioCondicionJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(CambioCondicionConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CambioCondicionEntity entity = CambioCondicionDboMapper.toEntity(cambioCondicion, userId, hospitalId);
        return CambioCondicionDboMapper.toDomain(cambioCondicionJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!cambioCondicionJpaRepository.existsById(id)) {
            throw new ResourceNotFoundException(CambioCondicionConstant.ID_NOT_FOUND);
        }
        cambioCondicionJpaRepository.deleteById(id);
    }

}
