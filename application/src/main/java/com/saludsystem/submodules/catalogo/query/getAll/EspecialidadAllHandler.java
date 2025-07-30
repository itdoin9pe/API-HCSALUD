package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadAllHandler {

    private final EspecialidadAllService especialidadAllService;

    public EspecialidadAllHandler(EspecialidadAllService especialidadAllService) {
        this.especialidadAllService = especialidadAllService;
    }

    public ListResponse<EspecialidadCreateCommand> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return especialidadAllService.execute(hospitalId, paginationRequest);
    }
}