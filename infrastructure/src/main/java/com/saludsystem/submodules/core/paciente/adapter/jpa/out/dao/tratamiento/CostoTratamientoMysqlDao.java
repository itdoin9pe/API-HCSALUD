package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.tratamiento;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.CostoTratamientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.CostoTratamientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.CostoTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CostoTratamientoMysqlDao implements CostoTratamientoDao {

    private final CostoTratamientoJpaRepository costoTratamientoJpaRepository;

    public CostoTratamientoMysqlDao(CostoTratamientoJpaRepository costoTratamientoJpaRepository) {
        this.costoTratamientoJpaRepository = costoTratamientoJpaRepository;
    }

    @Override
    public CostoTratamiento getById(UUID uuid) {
        return costoTratamientoJpaRepository.findById(uuid)
                .map(CostoTratamientoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(CostoTratamientoConstant.INVALID_ID));
    }

    @Override
    public ListResponse<CostoTratamiento> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = costoTratamientoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<CostoTratamiento> data = pageResult.getContent()
                .stream()
                .map(CostoTratamientoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<CostoTratamiento> getList() {
        return costoTratamientoJpaRepository.findAll()
                .stream()
                .map(CostoTratamientoDboMapper::toDomain)
                .toList();
    }

}
