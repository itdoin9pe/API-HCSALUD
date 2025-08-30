package com.saludsystem.submodules.core.cita.adapter.jpa.dao;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.core.cita.adapter.jpa.CitaJpaRepository;
import com.saludsystem.submodules.core.cita.adapter.mapper.CitaDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * The type Cita mysql dao.
 */
@Component
public class CitaMysqlDao implements CitaDao {

    private final CitaJpaRepository citaJpaRepository;

    /**
     * Instantiates a new Cita mysql dao.
     *
     * @param citaJpaRepository the cita jpa repository
     */
    public CitaMysqlDao(CitaJpaRepository citaJpaRepository) {
        this.citaJpaRepository = citaJpaRepository;
    }

    @Override
    public Cita getById(UUID uuid) {
        return citaJpaRepository.findById(uuid).map(CitaDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Cita> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = citaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Cita> data = pageResult.getContent().stream().map(CitaDboMapper::toDomain).toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
    }


    @Override
    public List<Cita> getList() {

        return citaJpaRepository.findAll().stream().map(CitaDboMapper::toDomain).toList();

    }
}
