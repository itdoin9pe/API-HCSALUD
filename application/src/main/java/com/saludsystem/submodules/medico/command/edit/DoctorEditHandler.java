package com.saludsystem.submodules.medico.command.edit;

import com.saludsystem.submodules.medico.dtos.ActualizarDoctorDTO;
import com.saludsystem.submodules.medico.service.DoctorEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorEditHandler {

    private final DoctorEditService doctorEditService;

    public DoctorEditHandler(DoctorEditService doctorEditService) {
        this.doctorEditService = doctorEditService;
    }

    public void execute(UUID uuid, ActualizarDoctorDTO dto) {
        doctorEditService.execute(uuid, dto);
    }
}
