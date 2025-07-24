package com.saludsystem.submodules.medico.port.dao;

import com.saludsystem.submodules.medico.model.Doctor;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface DoctorDao {

    Doctor getById(UUID uuid);
    ListResponse<Doctor> getAll(UUID hospitalId, int page, int rows);
    List<Doctor> getList();

}