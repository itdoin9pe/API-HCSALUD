package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.evolucion;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.CambioCondicionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.CambioCondicionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.CambioCondicionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CambioCondicionMysqlDao implements CambioCondicionDao {

    private final CambioCondicionJpaRepository cambioCondicionJpaRepository;

    public CambioCondicionMysqlDao(CambioCondicionJpaRepository cambioCondicionJpaRepository) {
        this.cambioCondicionJpaRepository = cambioCondicionJpaRepository;
    }

    @Override
    public CambioCondicion getById(Long id) {
        return cambioCondicionJpaRepository.findById(id)
                .map(CambioCondicionDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(CambioCondicionConstant.INVALID_ID));
    }

    @Override
    public ListResponse<CambioCondicion> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = cambioCondicionJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<CambioCondicion> data = pageResult.getContent()
                .stream()
                .map(CambioCondicionDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<CambioCondicion> getList() {
        return cambioCondicionJpaRepository.findAll()
                .stream()
                .map(CambioCondicionDboMapper::toDomain)
                .toList();
    }

}
