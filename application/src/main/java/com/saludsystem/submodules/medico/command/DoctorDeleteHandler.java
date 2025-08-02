package com.saludsystem.submodules.medico.command;

import com.saludsystem.submodules.medico.service.DoctorDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorDeleteHandler {

    private final DoctorDeleteService doctorDeleteService;

    public DoctorDeleteHandler(DoctorDeleteService doctorDeleteService) {
        this.doctorDeleteService = doctorDeleteService;
    }

    public void execute(UUID uuid) {
        doctorDeleteService.execute(uuid);
    }
}
