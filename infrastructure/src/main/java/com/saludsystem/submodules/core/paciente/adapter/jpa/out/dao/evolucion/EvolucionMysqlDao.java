package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.evolucion;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.EvolucionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.EvolucionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.EvolucionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EvolucionMysqlDao implements EvolucionDao {

    private final EvolucionJpaRepository evolucionJpaRepository;

    public EvolucionMysqlDao(EvolucionJpaRepository evolucionJpaRepository) {
        this.evolucionJpaRepository = evolucionJpaRepository;
    }

    @Override
    public Evolucion getById(UUID uuid) {
        return evolucionJpaRepository.findById(uuid)
                .map(EvolucionDboMapper::toDomain)
                .orElseThrow( () -> new ResourceNotFoundException(EvolucionConstant.INVALID_ID));
    }

    @Override
    public ListResponse<Evolucion> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = evolucionJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Evolucion> data = pageResult.getContent()
                .stream()
                .map(EvolucionDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }

    @Override
    public List<Evolucion> getList() {
        return evolucionJpaRepository.findAll()
                .stream()
                .map(EvolucionDboMapper::toDomain)
                .toList();
    }

}
