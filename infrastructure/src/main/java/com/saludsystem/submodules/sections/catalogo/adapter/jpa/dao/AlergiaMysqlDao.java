package com.saludsystem.submodules.sections.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.AlergiaEntity;
import com.saludsystem.submodules.sections.catalogo.adapter.jpa.AlergiaJpaRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.mapper.AlergiaDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AlergiaMysqlDao implements AlergiaRepository {

    private final AlergiaJpaRepository alergiaJpaRepository;

    public AlergiaMysqlDao(AlergiaJpaRepository alergiaJpaRepository) {
        this.alergiaJpaRepository = alergiaJpaRepository;
    }

    @Override
    public Alergia save(Alergia alergia) {
        AlergiaEntity entity = AlergiaDboMapper.toEntity(alergia);
        return AlergiaDboMapper.toDomain(alergiaJpaRepository.save(entity));
    }

    @Override
    public Alergia update(UUID id, Alergia alergia) {
        alergia.setId(id);
        AlergiaEntity entity = AlergiaDboMapper.toEntity(alergia);
        return AlergiaDboMapper.toDomain(alergiaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        alergiaJpaRepository.deleteById(id);
    }

    @Override
    public Alergia findById(UUID id) {
        return alergiaJpaRepository.findById(id).map(AlergiaDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Alergia> findAll(UUID hospitalId, int page, int rows) {
        return alergiaJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(AlergiaDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return alergiaJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}