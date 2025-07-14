package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Especialidad;
import com.saludsystem.domain.catalogo.port.out.repository.EspecialidadRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.EspecialidadJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.EspecialidadDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadRepositoryAdapter implements EspecialidadRepositoryPort {

    private final EspecialidadJpaRepository especialidadJpaRepository;

    public EspecialidadRepositoryAdapter(EspecialidadJpaRepository especialidadJpaRepository) {
        this.especialidadJpaRepository = especialidadJpaRepository;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));
    }

    @Override
    public Especialidad update(UUID uuid, Especialidad especialidad) {
        EspecialidadEntity entity = EspecialidadDboMapper.toEntity(especialidad);
        return EspecialidadDboMapper.toDomain(especialidadJpaRepository.save(entity));    }

    @Override
    public void delete(UUID uuid) {
        especialidadJpaRepository.deleteById(uuid);
    }

    @Override
    public Especialidad findById(UUID uuid) {
        return especialidadJpaRepository.findById(uuid).map(EspecialidadDboMapper::toDomain).orElse(null);
    }

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
