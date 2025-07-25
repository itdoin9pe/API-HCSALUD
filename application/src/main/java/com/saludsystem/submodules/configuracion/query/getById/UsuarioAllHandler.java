package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.service.UserAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioAllHandler {

    private final UserAllService userAllService;

    public UsuarioAllHandler(UserAllService userAllService) {
        this.userAllService = userAllService;
    }

    public ListResponse<UsuarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return userAllService.execute(hospitalId, paginationRequest);
    }

}
