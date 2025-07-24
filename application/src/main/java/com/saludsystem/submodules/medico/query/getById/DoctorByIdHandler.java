package com.saludsystem.submodules.medico.query.getById;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.service.DoctorByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorByIdHandler {

    private final DoctorByIdService doctorByIdService;

    public DoctorByIdHandler(DoctorByIdService doctorByIdService) {
        this.doctorByIdService = doctorByIdService;
    }

    public DoctorDTO execute(UUID uuid) {
        return doctorByIdService.execute(uuid);
    }

}
