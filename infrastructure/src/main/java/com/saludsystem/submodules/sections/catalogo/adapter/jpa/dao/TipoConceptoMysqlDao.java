package com.saludsystem.submodules.sections.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.sections.catalogo.adapter.jpa.TipoConceptoJpaRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.mapper.TipoConceptoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoConceptoMysqlDao implements TipoConceptoRepository {

    private final TipoConceptoJpaRepository tipoConceptoJpaRepository;

    public TipoConceptoMysqlDao(TipoConceptoJpaRepository tipoConceptoJpaRepository) {
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