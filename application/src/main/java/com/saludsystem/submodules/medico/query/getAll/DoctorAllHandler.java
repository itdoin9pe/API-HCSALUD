package com.saludsystem.submodules.medico.query.getAll;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.service.DoctorAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DoctorAllHandler {

    private final DoctorAllService doctorAllService;

    public DoctorAllHandler(DoctorAllService doctorAllService) {
        this.doctorAllService = doctorAllService;
    }

    public ListResponse<DoctorDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return doctorAllService.execute(hospitalId, paginationRequest);
    }
}
