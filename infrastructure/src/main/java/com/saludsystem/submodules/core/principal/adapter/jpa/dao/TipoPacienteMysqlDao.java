package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import com.saludsystem.submodules.core.principal.adapter.jpa.TipoPacienteJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.TipoPacienteDboMapper;
import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.constant.TipoPacienteConstant;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPacienteMysqlDao implements TipoPacienteDao {

    private final TipoPacienteJpaRepository tipoPacienteJpaRepository;

    public TipoPacienteMysqlDao(TipoPacienteJpaRepository tipoPacienteJpaRepository) {
        this.tipoPacienteJpaRepository = tipoPacienteJpaRepository;
    }

    @Override
    public TipoPaciente getById(Long id) {
        return tipoPacienteJpaRepository.findById(id).map(TipoPacienteDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(TipoPacienteConstant.ID_NOT_FOUND));
    }

    @Override
    public List<TipoPaciente> getList() {
        return tipoPacienteJpaRepository.findAll()
                .stream()
                .map(TipoPacienteDboMapper::toDomain)
                .toList();
    }
}
