package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.PacienteJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.PacienteDboMapper;
import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PacienteMysqlDao implements PacienteDao {

    private final PacienteJpaRepository pacienteJpaRepository;

    public PacienteMysqlDao(PacienteJpaRepository pacienteJpaRepository) {
        this.pacienteJpaRepository = pacienteJpaRepository;
    }

    @Override
    public Paciente getById(UUID uuid) {

        return pacienteJpaRepository.findById(uuid)
                .map(PacienteDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(PacienteConstant.INVALID_ID));

    }

    @Override
    public ListResponse<Paciente> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = pacienteJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Paciente> data = pageResult.getContent()
                .stream()
                .map(PacienteDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Paciente> getList() {

        return pacienteJpaRepository.findAll()
                .stream()
                .map(PacienteDboMapper::toDomain)
                .toList();

    }

}
