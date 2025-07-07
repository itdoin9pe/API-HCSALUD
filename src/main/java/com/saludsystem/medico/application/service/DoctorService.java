package com.saludsystem.medico.application.service;

import com.saludsystem.medico.application.dto.ActualizarDoctorDTO;
import com.saludsystem.medico.application.dto.CrearDoctorDTO;
import com.saludsystem.medico.application.dto.DoctorDTO;
import com.saludsystem.medico.domain.model.DoctorEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    DoctorEntity saveDoctor(CrearDoctorDTO crearDoctorDTO);

    List<DoctorDTO> getDoctorList();

    Optional<DoctorDTO> getDoctorById(UUID doctorId);

    ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO);

    ListResponse<DoctorDTO> getAllDoctor(UUID hospitalId, int page, int rows);

    void deleteDoctor(UUID doctorId);

}