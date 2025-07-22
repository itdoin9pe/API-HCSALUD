package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.banco.BancoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoDeleteHandler {

    private final BancoDeleteService bancoDeleteService;

    public BancoDeleteHandler(BancoDeleteService bancoDeleteService) {
        this.bancoDeleteService = bancoDeleteService;
    }

    public void execute(UUID uuid) {
        bancoDeleteService.execute(uuid);
    }
}
