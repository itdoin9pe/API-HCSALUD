package com.saludsystem.infrastructure.adapter.catalogo;

import com.saludsystem.domain.catalogo.model.Apoderado;
import com.saludsystem.domain.catalogo.port.out.repository.ApoderadoRepositoryPort;
import com.saludsystem.infrastructure.entity.catalogo.ApoderadoEntity;
import com.saludsystem.infrastructure.jparepository.catalogo.ApoderadoJpaRepository;
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

    private ApoderadoEntity toEntity(Apoderado apoderado) {
        ApoderadoEntity e = new ApoderadoEntity();
        e.setNombre(e.getNombre());
        e.setDireccion(e.getDireccion());
        e.setTelefono(e.getTelefono());
        e.setNroDocumento(e.getNroDocumento());
        e.setEstado(e.getEstado());
        return e;
    }

    private Apoderado toDomain(ApoderadoEntity e) {
        return new Apoderado(e.getApoderadoId(),
                e.getNombre(),
                e.getNroDocumento(),
                e.getTelefono(),
                e.getDireccion(),
                e.getEstado());
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        return toDomain(apoderadoJpaRepository.save(toEntity(apoderado)));
    }

    @Override
    public Apoderado update(UUID uuid, Apoderado apoderado) {
        apoderado.setId(uuid);
        return toDomain(apoderadoJpaRepository.save(toEntity(apoderado)));
    }

    @Override
    public void delete(UUID uuid) {
        apoderadoJpaRepository.deleteById(uuid);
    }

    @Override
    public Apoderado findById(UUID uuid) {
        return apoderadoJpaRepository.findById(uuid).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Apoderado> findAll(UUID hospitalId, int page, int rows) {
        return apoderadoJpaRepository.findAllHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(this::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return apoderadoJpaRepository.countByHospitalId(hospitalId);
    }
}
