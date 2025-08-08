package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.PConsentimientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.PConsentimientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.PConsentimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PConsentimientoMysqlDao implements PConsentimientoDao {

    private final PConsentimientoJpaRepository pConsentimientoJpaRepository;

    public PConsentimientoMysqlDao(PConsentimientoJpaRepository pConsentimientoJpaRepository) {
        this.pConsentimientoJpaRepository = pConsentimientoJpaRepository;
    }

    @Override
    public PacienteConsentimiento getById(UUID uuid) {
        return pConsentimientoJpaRepository.findById(uuid)
                .map(PConsentimientoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(PConsentimientoConstant.INVALID_ID));
    }

    @Override
    public ListResponse<PacienteConsentimiento> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = pConsentimientoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<PacienteConsentimiento> data = pageResult.getContent()
                .stream()
                .map(PConsentimientoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<PacienteConsentimiento> getList() {
        return pConsentimientoJpaRepository.findAll()
                .stream()
                .map(PConsentimientoDboMapper::toDomain)
                .toList();
    }

}
