package com.saludsystem.submodules.medico.query.getList;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.service.DoctorListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorListHandler {

    private final DoctorListService doctorListService;

    public DoctorListHandler(DoctorListService doctorListService) {
        this.doctorListService = doctorListService;
    }

    public List<DoctorDTO> execute() {
        return doctorListService.execute();
    }

}
