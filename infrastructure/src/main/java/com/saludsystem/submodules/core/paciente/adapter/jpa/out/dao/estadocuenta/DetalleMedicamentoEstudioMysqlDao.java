package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.estadocuenta;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.DetalleMedicamentoEstudioJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.DetalleMedicamentoEstudioDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.DetalleMedicamentoEstudioConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DetalleMedicamentoEstudioMysqlDao implements DetalleMedicamentoEstudioDao {

    private final DetalleMedicamentoEstudioJpaRepository detalleMedicamentoEstudioJpaRepository;

    public DetalleMedicamentoEstudioMysqlDao(DetalleMedicamentoEstudioJpaRepository detalleMedicamentoEstudioJpaRepository) {
        this.detalleMedicamentoEstudioJpaRepository = detalleMedicamentoEstudioJpaRepository;
    }

    @Override
    public DetalleMedicamentoEstudio getById(UUID uuid) {
        return detalleMedicamentoEstudioJpaRepository.findById(uuid)
                .map(DetalleMedicamentoEstudioDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(DetalleMedicamentoEstudioConstant.INVALID_ID));
    }

    @Override
    public ListResponse<DetalleMedicamentoEstudio> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = detalleMedicamentoEstudioJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<DetalleMedicamentoEstudio> data = pageResult.getContent()
                .stream()
                .map(DetalleMedicamentoEstudioDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<DetalleMedicamentoEstudio> getList() {
        return detalleMedicamentoEstudioJpaRepository.findAll()
                .stream()
                .map(DetalleMedicamentoEstudioDboMapper::toDomain)
                .toList();
    }
}
