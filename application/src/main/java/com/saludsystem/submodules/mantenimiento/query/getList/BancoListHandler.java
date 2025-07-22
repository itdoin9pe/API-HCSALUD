package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BancoListHandler {

    private final BancoListService bancoListService;

    public BancoListHandler(BancoListService bancoListService) {
        this.bancoListService = bancoListService;
    }

    public List<BancoDTO> execute() {
        return bancoListService.execute();
    }
}
