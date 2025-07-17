package com.saludsystem.submodules.sections.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.entity.TipoCitadoEntity;
import com.saludsystem.submodules.sections.catalogo.adapter.jpa.TipoCitadoJpaRepository;
import com.saludsystem.submodules.sections.catalogo.adapter.mapper.TipoCitadoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoCitadoMysqlDao implements TipoCitadoRepository {

    private final TipoCitadoJpaRepository tipoCitadoJpaRepository;

    public TipoCitadoMysqlDao(TipoCitadoJpaRepository tipoCitadoJpaRepository) {
        this.tipoCitadoJpaRepository = tipoCitadoJpaRepository;
    }

    @Override
    public TipoCitado save(TipoCitado tipoCitado) {
        TipoCitadoEntity entity = TipoCitadoDboMapper.toEntity(tipoCitado);
        return TipoCitadoDboMapper.toDomain(tipoCitadoJpaRepository.save(entity));
    }

    @Override
    public TipoCitado update(UUID uuid, TipoCitado tipoCitado) {
        TipoCitadoEntity entity = TipoCitadoDboMapper.toEntity(tipoCitado);
        return TipoCitadoDboMapper.toDomain(tipoCitadoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        tipoCitadoJpaRepository.deleteById(uuid);
    }

    @Override
    public TipoCitado findById(UUID uuid) {
        return tipoCitadoJpaRepository.findById(uuid).map(TipoCitadoDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<TipoCitado> findAll(UUID hospitalId, int page, int rows) {
        return tipoCitadoJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(TipoCitadoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return tipoCitadoJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}
