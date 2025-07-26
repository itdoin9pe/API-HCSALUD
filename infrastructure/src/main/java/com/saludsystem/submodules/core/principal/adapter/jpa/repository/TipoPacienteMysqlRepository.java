package com.saludsystem.submodules.core.principal.adapter.jpa.repository;

import com.saludsystem.submodules.core.principal.adapter.entity.TipoPacienteEntity;
import com.saludsystem.submodules.core.principal.adapter.jpa.TipoPacienteJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.TipoPacienteDboMapper;
import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteMysqlRepository implements TipoPacienteRepository {

    private final TipoPacienteJpaRepository tipoPacienteJpaRepository;

    public TipoPacienteMysqlRepository(TipoPacienteJpaRepository tipoPacienteJpaRepository) {
        this.tipoPacienteJpaRepository = tipoPacienteJpaRepository;
    }

    @Override
    public TipoPaciente save(TipoPaciente tipoPaciente) {
        TipoPacienteEntity entity = TipoPacienteDboMapper.toEntity(tipoPaciente);
        return TipoPacienteDboMapper.toDomain(tipoPacienteJpaRepository.save(entity));
    }

    @Override
    public TipoPaciente update(Long uuid, TipoPaciente tipoPaciente) {
        TipoPacienteEntity entity = TipoPacienteDboMapper.toEntity(tipoPaciente);
        return TipoPacienteDboMapper.toDomain(tipoPacienteJpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        tipoPacienteJpaRepository.deleteById(id);
    }
}
