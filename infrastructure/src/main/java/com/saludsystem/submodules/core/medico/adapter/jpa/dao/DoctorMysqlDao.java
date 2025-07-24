package com.saludsystem.submodules.core.medico.adapter.jpa.dao;

import com.saludsystem.submodules.core.medico.adapter.jpa.DoctorJpaRepository;
import com.saludsystem.submodules.core.medico.adapter.mapper.DoctorDboMapper;
import com.saludsystem.submodules.medico.constant.DoctorConstant;
import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DoctorMysqlDao implements DoctorDao {

    private final DoctorJpaRepository doctorJpaRepository;

    public DoctorMysqlDao(DoctorJpaRepository doctorJpaRepository) {
        this.doctorJpaRepository = doctorJpaRepository;
    }

    @Override
    public Doctor getById(UUID uuid) {
        return doctorJpaRepository.findById(uuid).map(DoctorDboMapper::toDomain).
                orElseThrow( () -> new ResourceNotFoundException(DoctorConstant.ID_NOT_FOUND));
    }

    @Override
    public ListResponse<Doctor> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = doctorJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Doctor> data = pageResult.getContent().stream().map(DoctorDboMapper::toDomain).toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Doctor> getList() {
        return doctorJpaRepository.findAll().stream().map(DoctorDboMapper::toDomain).toList();
    }
}
