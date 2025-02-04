package com.saludSystem.services.modules.Doctor.impl;

import com.saludSystem.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.dtos.Doctor.DoctorDTO;
import com.saludSystem.services.modules.Doctor.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class DoctorServiceImpl implements DoctorService {
    @Override
    public CrearDoctorDTO saveDoctor(CrearDoctorDTO crearDoctorDTO) {
        return null;
    }

    @Override
    public List<DoctorDTO> getDoctorList() {
        return List.of();
    }

    @Override
    public Optional<DoctorDTO> getDoctorById(UUID doctorId) {
        return Optional.empty();
    }

    @Override
    public ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO) {
        return null;
    }

    @Override
    public void deleteDoctor(UUID doctorId) {

    }

    @Override
    public long getTotalCount() {
        return 0;
    }

    @Override
    public <T> List<T> getPagedResults(UUID hospitalId, int page, int rows) {
        return List.of();
    }
}
