package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import com.saludsystem.submodules.core.catalogo.adapter.entity.ApoderadoEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ApoderadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ApoderadoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoderadoMysqlDao implements ApoderadoRepository {

    private final ApoderadoJpaRepository apoderadoJpaRepository;

    public ApoderadoMysqlDao(ApoderadoJpaRepository apoderadoJpaRepository) {
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
        return apoderadoJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(ApoderadoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return apoderadoJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}