package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.MedidaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.MedidaDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedidaMysqlDao implements MedidaRepository {

    private final MedidaJpaRepository medidaJpaRepository;

    public MedidaMysqlDao(MedidaJpaRepository medidaJpaRepository) {
        this.medidaJpaRepository = medidaJpaRepository;
    }

    @Override
    public Medida save(Medida medida) {
        MedidaEntity entity = MedidaDboMapper.toEntity(medida);
        return MedidaDboMapper.toDomain(medidaJpaRepository.save(entity));
    }

    @Override
    public Medida update(UUID uuid, Medida medida) {
        MedidaEntity entity = MedidaDboMapper.toEntity(medida);
        return MedidaDboMapper.toDomain(medidaJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        medidaJpaRepository.deleteById(uuid);
    }

    @Override
    public Medida findById(UUID uuid) {
        return medidaJpaRepository.findById(uuid).map(MedidaDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Medida> findAll(UUID hospitalId, int page, int rows) {
        return medidaJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(MedidaDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return medidaJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}