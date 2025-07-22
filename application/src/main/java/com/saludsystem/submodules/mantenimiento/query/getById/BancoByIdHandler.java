package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoByIdHandler {

    private final BancoByIdService bancoByIdService;

    public BancoByIdHandler(BancoByIdService bancoByIdService) {
        this.bancoByIdService = bancoByIdService;
    }

    public BancoDTO execute(UUID uuid) {
        return bancoByIdService.execute(uuid);
    }
}
