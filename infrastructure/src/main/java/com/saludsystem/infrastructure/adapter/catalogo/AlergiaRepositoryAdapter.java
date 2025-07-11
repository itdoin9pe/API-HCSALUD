package com.saludsystem.infrastructure.adapter.catalogo;

import com.saludsystem.domain.catalogo.model.Alergia;
import com.saludsystem.domain.catalogo.port.out.repository.AlergiaRepositoryPort;
import com.saludsystem.infrastructure.entity.catalogo.AlergiaEntity;
import com.saludsystem.infrastructure.jparepository.catalogo.AlergiaJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AlergiaRepositoryAdapter implements AlergiaRepositoryPort {

    private final AlergiaJpaRepository alergiaJpaRepository;

    public AlergiaRepositoryAdapter(AlergiaJpaRepository alergiaJpaRepository) {
        this.alergiaJpaRepository = alergiaJpaRepository;
    }

    private AlergiaEntity toEntity(Alergia alergia) {
        AlergiaEntity entity = new AlergiaEntity();
        entity.setAlergiaId(alergia.getId());
        entity.setNombre(alergia.getNombre());
        entity.setEstado(alergia.getEstado());
        return entity;
    }

    private Alergia toDomain(AlergiaEntity e) {
        return new Alergia(e.getAlergiaId(), e.getNombre(), e.getEstado());
    }

    @Override
    public Alergia save(Alergia alergia) {
        return toDomain(alergiaJpaRepository.save(toEntity(alergia)));
    }

    @Override
    public Alergia update(UUID id, Alergia alergia) {
        alergia.setId(id);
        return toDomain(alergiaJpaRepository.save(toEntity(alergia)));
    }

    @Override
    public void delete(UUID id) {
        alergiaJpaRepository.deleteById(id);
    }

    @Override
    public Alergia findById(UUID id) {
        return alergiaJpaRepository.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Alergia> findAll(UUID hospitalId, int page, int rows) {
        return alergiaJpaRepository.findAllByHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(this::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return alergiaJpaRepository.countByHospitalId(hospitalId);
    }
}