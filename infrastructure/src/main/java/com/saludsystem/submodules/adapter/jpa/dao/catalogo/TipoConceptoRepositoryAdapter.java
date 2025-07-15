package com.saludsystem.submodules.adapter.jpa.dao.catalogo;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.out.repository.TipoConceptoRepositoryPort;
import com.saludsystem.submodules.adapter.entity.catalogo.TipoConceptoEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.TipoConceptoJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.TipoConceptoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoConceptoRepositoryAdapter implements TipoConceptoRepositoryPort {

    private final TipoConceptoJpaRepository tipoConceptoJpaRepository;

    public TipoConceptoRepositoryAdapter(TipoConceptoJpaRepository tipoConceptoJpaRepository) {
        this.tipoConceptoJpaRepository = tipoConceptoJpaRepository;
    }

    @Override
    public TipoConcepto save(TipoConcepto tipoConcepto) {
        TipoConceptoEntity entity = TipoConceptoDboMapper.toEntity(tipoConcepto);
        return TipoConceptoDboMapper.toDomain(tipoConceptoJpaRepository.save(entity));
    }

    @Override
    public TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto) {
        TipoConceptoEntity entity = TipoConceptoDboMapper.toEntity(tipoConcepto);
        return TipoConceptoDboMapper.toDomain(tipoConceptoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        tipoConceptoJpaRepository.deleteById(uuid);
    }

    @Override
    public TipoConcepto findById(UUID uuid) {
        return tipoConceptoJpaRepository.findById(uuid).map(TipoConceptoDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<TipoConcepto> findAll(UUID hospitalId, int page, int rows) {
        return tipoConceptoJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(TipoConceptoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return tipoConceptoJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}