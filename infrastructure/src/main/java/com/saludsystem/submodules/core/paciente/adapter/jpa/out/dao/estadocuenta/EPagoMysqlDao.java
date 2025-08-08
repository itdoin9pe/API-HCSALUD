package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.estadocuenta;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.EPagoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.EPagoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EPagoConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EPagoMysqlDao implements EPagoDao {

    private final EPagoJpaRepository ePagoJpaRepository;

    public EPagoMysqlDao(EPagoJpaRepository ePagoJpaRepository) {
        this.ePagoJpaRepository = ePagoJpaRepository;
    }

    @Override
    public EPago getById(UUID uuid) {
        return ePagoJpaRepository.findById(uuid)
                .map(EPagoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EPagoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<EPago> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = ePagoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<EPago> data = pageResult.getContent()
                .stream()
                .map(EPagoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<EPago> getList() {
        return ePagoJpaRepository.findAll()
                .stream()
                .map(EPagoDboMapper::toDomain)
                .toList();
    }
}
