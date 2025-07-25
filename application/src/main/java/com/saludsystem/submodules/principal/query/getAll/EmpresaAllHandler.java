package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.model.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.service.empresa.EmpresaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmpresaAllHandler {

    private final EmpresaAllService empresaAllService;

    public EmpresaAllHandler(EmpresaAllService empresaAllService) {
        this.empresaAllService = empresaAllService;
    }

    public ListResponse<EmpresaDTO> execute(UUID uuid, PaginationRequest paginationRequest) {
        return empresaAllService.execute(uuid, paginationRequest);
    }

}
