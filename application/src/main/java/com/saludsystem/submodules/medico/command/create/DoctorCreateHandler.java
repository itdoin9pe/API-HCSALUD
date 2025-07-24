package com.saludsystem.submodules.medico.command.create;

import com.saludsystem.submodules.medico.dtos.CrearDoctorDTO;
import com.saludsystem.submodules.medico.service.DoctorCreateService;
import org.springframework.stereotype.Component;

@Component
public class DoctorCreateHandler {

    private final DoctorCreateService doctorCreateService;

    public DoctorCreateHandler(DoctorCreateService doctorCreateService) {
        this.doctorCreateService = doctorCreateService;
    }

    public void execute(CrearDoctorDTO dto) {
        doctorCreateService.execute(dto);
    }

}
