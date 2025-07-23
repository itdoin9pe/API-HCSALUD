package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.EnfermedadEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.EnfermedadJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.EnfermedadDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EnfermedadMysqlRepository implements EnfermedadRepository {

    private final EnfermedadJpaRepository enfermedadJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EnfermedadMysqlRepository(EnfermedadJpaRepository enfermedadJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.enfermedadJpaRepository = enfermedadJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Enfermedad save(Enfermedad enfermedad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EnfermedadEntity entity = EnfermedadDboMapper.toEntity(enfermedad, userId, hospitalId);
        return EnfermedadDboMapper.toDomain(enfermedadJpaRepository.save(entity));
    }

    @Override
    public Enfermedad update(UUID uuid, Enfermedad enfermedad) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        EnfermedadEntity entity = EnfermedadDboMapper.toEntity(enfermedad, userId, hospitalId);
        return EnfermedadDboMapper.toDomain(enfermedadJpaRepository.save(entity));
    }

    @Override
    public void delete(String id) {
        enfermedadJpaRepository.deleteById(id);
    }
}
