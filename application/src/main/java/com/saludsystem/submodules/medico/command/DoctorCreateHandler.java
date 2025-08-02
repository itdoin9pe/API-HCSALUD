package com.saludsystem.submodules.medico.command;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.dtos.DoctorCreateCommand;
import com.saludsystem.submodules.medico.service.DoctorCreateService;
import org.springframework.stereotype.Component;

@Component
public class DoctorCreateHandler {

    private final DoctorCreateService doctorCreateService;
    private final DoctorMapper doctorMapper;

    public DoctorCreateHandler(DoctorCreateService doctorCreateService, DoctorMapper doctorMapper) {
        this.doctorCreateService = doctorCreateService;
        this.doctorMapper = doctorMapper;
    }

    public void execute(DoctorCreateCommand createCommand) {

        var doctor = doctorMapper.fromCreateDto(createCommand);

        doctorCreateService.execute(doctor);

    }

}
