package com.saludsystem.domain.medico.port.in.service;

import com.saludsystem.domain.medico.model.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    Doctor save(Doctor docto);
    Doctor update(UUID uuid, Doctor tipoCitado);
    void delete(UUID uuid);
    Doctor getById(UUID uuid);
    List<Doctor> getAll(UUID hospitalId, int page, int rows);

}