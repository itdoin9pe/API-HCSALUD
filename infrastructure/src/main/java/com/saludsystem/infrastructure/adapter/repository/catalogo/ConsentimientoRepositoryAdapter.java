package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Consentimiento;
import com.saludsystem.domain.catalogo.port.out.repository.ConsentimientoRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.ConsentimientoEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.ConsentimientoJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.ConsentimientoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoRepositoryAdapter implements ConsentimientoRepositoryPort {

    private final ConsentimientoJpaRepository consentimientoJpaRepository;

    public ConsentimientoRepositoryAdapter(ConsentimientoJpaRepository consentimientoJpaRepository) {
        this.consentimientoJpaRepository = consentimientoJpaRepository;
    }

    @Override
    public Consentimiento save(Consentimiento consentimiento) {
        ConsentimientoEntity entity = ConsentimientoDboMapper.toEntity(consentimiento);
        return ConsentimientoDboMapper.toDomain(consentimientoJpaRepository.save(entity));
    }

    @Override
    public Consentimiento update(UUID uuid, Consentimiento consentimiento) {
        consentimiento.setId(uuid);
        ConsentimientoEntity entity = ConsentimientoDboMapper.toEntity(consentimiento);
        return ConsentimientoDboMapper.toDomain(consentimientoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        consentimientoJpaRepository.deleteById(uuid);
    }

    @Override
    public Consentimiento findById(UUID uuid) {
        return consentimientoJpaRepository.findById(uuid).map(ConsentimientoDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Consentimiento> findAll(UUID hospitalId, int page, int rows) {
        return consentimientoJpaRepository.findAllHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(ConsentimientoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return consentimientoJpaRepository.countByHospitalId(hospitalId);
    }
}
