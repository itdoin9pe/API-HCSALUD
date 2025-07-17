package com.saludsystem.submodules.adapter.jpa.dao.catalogo;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;
import com.saludsystem.submodules.adapter.entity.catalogo.ConsentimientoEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.ConsentimientoJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.ConsentimientoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoRepositoryAdapter implements ConsentimientoRepository {

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
        return consentimientoJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(ConsentimientoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return consentimientoJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}
