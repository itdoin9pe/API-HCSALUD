package com.saludSystem.application.services.Medico;

import com.saludSystem.application.dtos.Medico.ActualizarDoctorDTO;
import com.saludSystem.application.dtos.Medico.CrearDoctorDTO;
import com.saludSystem.application.dtos.Medico.DoctorDTO;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.model.Medico.DoctorEntity;

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