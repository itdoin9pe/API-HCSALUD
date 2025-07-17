package com.saludsystem.submodules.adapter.jpa.dao.catalogo;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import com.saludsystem.submodules.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.EspecialidadJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.EspecialidadDboMapper;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadMyslDao implements EspecialidadRepository {

    private final EspecialidadJpaRepository especialidadJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EspecialidadMyslDao(EspecialidadJpaRepository especialidadJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.especialidadJpaRepository = especialidadJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad, userId, hospitalId);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));
    }

    @Override
    public Especialidad update(UUID uuid, Especialidad especialidad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad, userId, hospitalId);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        especialidadJpaRepository.deleteById(uuid);
    }

}
