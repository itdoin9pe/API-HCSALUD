package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.AlergiaDboMapper;
import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.EstudioMedicoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.EstudioMedicoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioMedicoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudioMedicoMysqlDao implements EstudioMedicoDao {

    private final EstudioMedicoJpaRepository estudioMedicoJpaRepository;

    public EstudioMedicoMysqlDao(EstudioMedicoJpaRepository estudioMedicoJpaRepository) {
        this.estudioMedicoJpaRepository = estudioMedicoJpaRepository;
    }

    @Override
    public EstudioMedico getById(Long id) {
        return estudioMedicoJpaRepository.findById(id)
                .map(EstudioMedicoDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EstudioMedicoConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<EstudioMedico> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = estudioMedicoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<EstudioMedico> data = pageResult.getContent()
                .stream()
                .map(EstudioMedicoDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<EstudioMedico> getList() {
        return estudioMedicoJpaRepository.findAll()
                .stream()
                .map(EstudioMedicoDboMapper::toDomain)
                .toList();
    }

}
