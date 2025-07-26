package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformacionClinicaAllHandler {

    private final InformacionClinicaAllService informacionClinicaAllService;

    public InformacionClinicaAllHandler(InformacionClinicaAllService informacionClinicaAllService) {
        this.informacionClinicaAllService = informacionClinicaAllService;
    }

    public ListResponse<InformacionClinicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return informacionClinicaAllService.execute(hospitalId, paginationRequest);
    }

}
