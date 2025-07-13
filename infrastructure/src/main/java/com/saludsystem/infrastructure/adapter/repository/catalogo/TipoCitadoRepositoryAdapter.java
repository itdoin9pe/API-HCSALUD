package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.TipoCitado;
import com.saludsystem.domain.catalogo.port.out.repository.TipoCitadoRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.TipoCitadoEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.TipoCitadoJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.TipoCitadoDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoCitadoRepositoryAdapter implements TipoCitadoRepositoryPort {

    private final TipoCitadoJpaRepository tipoCitadoJpaRepository;

    public TipoCitadoRepositoryAdapter(TipoCitadoJpaRepository tipoCitadoJpaRepository) {
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
        return tipoCitadoJpaRepository.findAllHospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(TipoCitadoDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return tipoCitadoJpaRepository.countByHospitalId(hospitalId);
    }
}
