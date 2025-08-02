package com.saludsystem.submodules.medico.command;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.dtos.DoctorEditCommand;
import com.saludsystem.submodules.medico.service.DoctorEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorEditHandler {

    private final DoctorEditService doctorEditService;
    private final DoctorMapper doctorMapper;

    public DoctorEditHandler(DoctorEditService doctorEditService, DoctorMapper doctorMapper) {
        this.doctorEditService = doctorEditService;
        this.doctorMapper = doctorMapper;
    }

    public void execute(UUID uuid, DoctorEditCommand editCommand) {

        var doctor = doctorMapper.fromUpdateDto(uuid, editCommand);

        doctorEditService.execute(uuid, doctor);

    }

}
