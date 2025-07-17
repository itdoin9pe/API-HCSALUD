package com.saludsystem.submodules.adapter.jpa.repository.catalogo;

import com.saludsystem.submodules.adapter.jpa.interfaces.catalogo.EspecialidadJpaRepository;
import com.saludsystem.submodules.adapter.mapper.catalogo.EspecialidadDboMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadMysqlRepository implements EspecialidadDao {

    private final EspecialidadJpaRepository especialidadJpaRepository;

    public EspecialidadMysqlRepository(EspecialidadJpaRepository especialidadJpaRepository) {
        this.especialidadJpaRepository = especialidadJpaRepository;
    }

    @Override
    public Especialidad getById(UUID uuid) {
        return especialidadJpaRepository.findById(uuid).map(EspecialidadDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Especialidad> getAll(UUID hospitalId, int page, int rows) {
        var pageable = PageRequest.of(page, rows);
        var pageResult = especialidadJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<Especialidad> data = pageResult.getContent()
                .stream()
                .map(EspecialidadDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page + 1);
    }

    @Override
    public List<Especialidad> getList() {
        return especialidadJpaRepository.findAll().stream().map(EspecialidadDboMapper::toDomain).toList();
    }
}
