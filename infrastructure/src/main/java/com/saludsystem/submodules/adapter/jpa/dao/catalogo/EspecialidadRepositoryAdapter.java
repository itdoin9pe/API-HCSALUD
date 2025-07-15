package com.saludsystem.submodules.adapter.jpa.dao.catalogo;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.out.repository.EspecialidadRepositoryPort;
import com.saludsystem.submodules.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.EspecialidadJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.EspecialidadDboMapper;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadRepositoryAdapter implements EspecialidadRepositoryPort {

    private final EspecialidadJpaRepository especialidadJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public EspecialidadRepositoryAdapter(EspecialidadJpaRepository especialidadJpaRepository, AuthenticateUserPort authenticateUserPort) {
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

    @Override
    public Especialidad findById(UUID uuid) {
        return especialidadJpaRepository.findById(uuid).map(EspecialidadDboMapper::toDomain).orElse(null);
    }

    /*
    @Override
    public List<Especialidad> findAll() {
        return especialidadJpaRepository.findAll().stream().map(EspecialidadDboMapper::toDomain).toList();
    }*/


    @Override
    public List<Especialidad> findAll(UUID hospitalId, int page, int rows) {
        return especialidadJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(EspecialidadDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return especialidadJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}
