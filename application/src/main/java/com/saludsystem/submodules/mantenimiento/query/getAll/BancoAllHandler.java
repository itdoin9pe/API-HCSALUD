package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoAllHandler {

    private final BancoAllService bancoAllService;

    public BancoAllHandler(BancoAllService bancoAllService) {
        this.bancoAllService = bancoAllService;
    }

    public ListResponse<BancoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return bancoAllService.execute(hospitalId, paginationRequest);
    }

}
