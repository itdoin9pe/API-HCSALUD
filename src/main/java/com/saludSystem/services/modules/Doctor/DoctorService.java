package com.saludSystem.services.modules.Doctor;

import com.saludSystem.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.dtos.Doctor.DoctorDTO;
import com.saludSystem.entities.Doctor;
import com.saludSystem.services.PaginatedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService extends PaginatedService {

    Doctor saveDoctor(CrearDoctorDTO crearDoctorDTO);

    List<DoctorDTO> getDoctorList();

    Optional<DoctorDTO> getDoctorById(UUID doctorId);

    ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO);

    void deleteDoctor(UUID doctorId);

}
