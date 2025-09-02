package com.saludsystem.submodules.core.paciente.adapter.jpa.out.repository.tratamiento;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.tratamiento.CostoTratamientoEntity;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.CostoTratamientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.CostoTratamientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.CostoTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.CostoTratamientoRepository;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CostoTratamientoMysqlRepository implements CostoTratamientoRepository {

    private final CostoTratamientoJpaRepository costoTratamientoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public CostoTratamientoMysqlRepository(CostoTratamientoJpaRepository costoTratamientoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.costoTratamientoJpaRepository = costoTratamientoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public CostoTratamiento save(CostoTratamiento costoTratamiento) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CostoTratamientoEntity entity = CostoTratamientoDboMapper.toEntity(costoTratamiento, userId, hospitalId);
        return CostoTratamientoDboMapper.toDomain(costoTratamientoJpaRepository.save(entity));
    }

    @Override
    public CostoTratamiento update(UUID uuid, CostoTratamiento costoTratamiento) {
        if (!costoTratamientoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CostoTratamientoConstant.ID_NOT_FOUND);
        }
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        CostoTratamientoEntity entity = CostoTratamientoDboMapper.toEntity(costoTratamiento, userId, hospitalId);
        return CostoTratamientoDboMapper.toDomain(costoTratamientoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        if (!costoTratamientoJpaRepository.existsById(uuid)) {
            throw new ResourceNotFoundException(CostoTratamientoConstant.ID_NOT_FOUND);
        }
        costoTratamientoJpaRepository.deleteById(uuid);
    }

}
