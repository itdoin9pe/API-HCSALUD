package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Medida;
import com.saludsystem.domain.catalogo.port.out.repository.MedidaRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.MedidaEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.MedidaJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.MedidaDboMapper;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public class MedidaRepositoryAdapter implements MedidaRepositoryPort {

    private final MedidaJpaRepository medidaJpaRepository;

    public MedidaRepositoryAdapter(MedidaJpaRepository medidaJpaRepository) {
        this.medidaJpaRepository = medidaJpaRepository;
    }

    @Override
    public Medida save(Medida medida) {
        MedidaEntity entity = MedidaDboMapper.toEntity(medida);
        return MedidaDboMapper.toDomain(medidaJpaRepository.save(entity));
    }

    @Override
    public Medida update(UUID uuid, Medida medida) {
        medida.setId(uuid);
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
        return medidaJpaRepository.findAllHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(MedidaDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return medidaJpaRepository.countByHospitalId(hospitalId);
    }
}