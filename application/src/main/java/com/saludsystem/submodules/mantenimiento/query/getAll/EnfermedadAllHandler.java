package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EnfermedadAllHandler {

    private final EnfermedadAllService enfermedadAllService;

    public EnfermedadAllHandler(EnfermedadAllService enfermedadAllService) {
        this.enfermedadAllService = enfermedadAllService;
    }

    public ListResponse<EnfermedadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return enfermedadAllService.execute(hospitalId, paginationRequest);
    }
}
