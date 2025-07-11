package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Apoderado;
import com.saludsystem.domain.catalogo.port.out.repository.ApoderadoRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.ApoderadoEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.ApoderadoJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.ApoderadoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoderadoRepositoryAdapter implements ApoderadoRepositoryPort {

    private final ApoderadoJpaRepository apoderadoJpaRepository;

    public ApoderadoRepositoryAdapter(ApoderadoJpaRepository apoderadoJpaRepository) {
        this.apoderadoJpaRepository = apoderadoJpaRepository;
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado);
        return ApoderadoDboMapper.toDomain(apoderadoJpaRepository.save(entity));
    }

    @Override
    public Apoderado update(UUID uuid, Apoderado apoderado) {
        apoderado.setId(uuid);
        ApoderadoEntity entity = ApoderadoDboMapper.toEntity(apoderado);
        return ApoderadoDboMapper.toDomain(apoderadoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        apoderadoJpaRepository.deleteById(uuid);
    }

    @Override
    public Apoderado findById(UUID uuid) {
        return apoderadoJpaRepository.findById(uuid).map(ApoderadoDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Apoderado> findAll(UUID hospitalId, int page, int rows) {
        return apoderadoJpaRepository.findAllHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(ApoderadoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return apoderadoJpaRepository.countByHospitalId(hospitalId);
    }
}