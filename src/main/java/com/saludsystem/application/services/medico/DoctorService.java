package com.saludsystem.application.services.medico;

import com.saludsystem.application.dtos.medico.ActualizarDoctorDTO;
import com.saludsystem.application.dtos.medico.CrearDoctorDTO;
import com.saludsystem.application.dtos.medico.DoctorDTO;
import com.saludsystem.domain.model.medico.DoctorEntity;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;


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