package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.EstudioResultadoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.EstudioResultadoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioResultadoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudioResultadoMysqlDao implements EstudioResultadoDao {

    private final EstudioResultadoJpaRepository estudioResultadoJpaRepository;

    public EstudioResultadoMysqlDao(EstudioResultadoJpaRepository estudioResultadoJpaRepository) {
        this.estudioResultadoJpaRepository = estudioResultadoJpaRepository;
    }

    @Override
    public EstudioResultado getById(Long id) {
        return estudioResultadoJpaRepository.findById(id)
                .map(EstudioResultadoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EstudioResultadoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<EstudioResultado> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = estudioResultadoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<EstudioResultado> data = pageResult.getContent()
                .stream()
                .map(EstudioResultadoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<EstudioResultado> getList() {
        return estudioResultadoJpaRepository.findAll()
                .stream()
                .map(EstudioResultadoDboMapper::toDomain)
                .toList();
    }

}
