package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.interconsulta;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta.InterconsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta.InterconsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InterconsultaMysqlDao implements InterconsultaDao {

    private final InterconsultaJpaRepository interconsultaJpaRepository;

    public InterconsultaMysqlDao(InterconsultaJpaRepository interconsultaJpaRepository) {
        this.interconsultaJpaRepository = interconsultaJpaRepository;
    }

    @Override
    public List<Interconsulta> getList() {
        return interconsultaJpaRepository.findAll()
                .stream()
                .map(InterconsultaDboMapper::toDomain)
                .toList();
    }

    @Override
    public Interconsulta getById(UUID uuid) {
        return interconsultaJpaRepository.findById(uuid)
                .map(InterconsultaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(InterconsultaConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Interconsulta> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = interconsultaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Interconsulta> data = pageResult.getContent()
                .stream()
                .map(InterconsultaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

}
