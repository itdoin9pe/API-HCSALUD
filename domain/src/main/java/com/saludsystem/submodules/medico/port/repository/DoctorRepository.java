package com.saludsystem.submodules.medico.port.repository;

import com.saludsystem.submodules.medico.model.Doctor;

import java.util.UUID;

public interface DoctorRepository {
    Doctor save(Doctor doctor);
    Doctor update(UUID uuid, Doctor doctor);
    void delete(UUID uuid);
}