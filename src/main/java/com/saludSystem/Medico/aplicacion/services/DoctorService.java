package com.saludSystem.Medico.aplicacion.services;

import com.saludSystem.Medico.aplicacion.dtos.ActualizarDoctorDTO;
import com.saludSystem.Medico.aplicacion.dtos.CrearDoctorDTO;
import com.saludSystem.Medico.aplicacion.dtos.DoctorDTO;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Medico.dominio.DoctorModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    DoctorModel saveDoctor(CrearDoctorDTO crearDoctorDTO);

    List<DoctorDTO> getDoctorList();

    Optional<DoctorDTO> getDoctorById(UUID doctorId);

    ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO);

    ListResponse<DoctorDTO> getAllDoctor(UUID hospitalId, int page, int rows);

    void deleteDoctor(UUID doctorId);

}