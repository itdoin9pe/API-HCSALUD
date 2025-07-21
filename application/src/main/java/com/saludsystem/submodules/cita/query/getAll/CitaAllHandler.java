package com.saludsystem.submodules.cita.query.getAll;

import com.saludsystem.submodules.cita.model.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.service.CitaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaAllHandler {

    private final CitaAllService citaAllService;

    public CitaAllHandler(CitaAllService citaAllService) {
        this.citaAllService = citaAllService;
    }

    public ListResponse<CitaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        return citaAllService.execute(hospitalId, paginationRequest);

    }

}