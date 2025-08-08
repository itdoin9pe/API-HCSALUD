package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.estadocuenta;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.EstadoCuentaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.EstadoCuentaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EstadoCuentaConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstadoCuentaMysqlDao implements EstadoCuentaDao {

    private final EstadoCuentaJpaRepository estadoCuentaJpaRepository;

    public EstadoCuentaMysqlDao(EstadoCuentaJpaRepository estadoCuentaJpaRepository) {
        this.estadoCuentaJpaRepository = estadoCuentaJpaRepository;
    }

    @Override
    public EstadoCuenta getById(UUID uuid) {
        return estadoCuentaJpaRepository.findById(uuid)
                .map(EstadoCuentaDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EstadoCuentaConstant.INVALID_ID));
    }

    @Override
    public ListResponse<EstadoCuenta> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = estadoCuentaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<EstadoCuenta> data = pageResult.getContent()
                .stream()
                .map(EstadoCuentaDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<EstadoCuenta> getList() {
        return estadoCuentaJpaRepository.findAll()
                .stream()
                .map(EstadoCuentaDboMapper::toDomain)
                .toList();
    }
}
