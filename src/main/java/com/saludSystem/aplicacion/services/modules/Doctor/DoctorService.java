package com.saludSystem.aplicacion.services.modules.Doctor;

import com.saludSystem.aplicacion.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.aplicacion.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.aplicacion.dtos.Doctor.DoctorDTO;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
import com.saludSystem.dominio.entities.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    Doctor saveDoctor(CrearDoctorDTO crearDoctorDTO);

    List<DoctorDTO> getDoctorList();

    Optional<DoctorDTO> getDoctorById(UUID doctorId);

    ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO);

    ListResponse<DoctorDTO> getAllDoctor(UUID hospitalId, int page, int rows);

    void deleteDoctor(UUID doctorId);

}