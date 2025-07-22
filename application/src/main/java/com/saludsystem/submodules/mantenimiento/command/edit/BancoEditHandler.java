package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarBancoDTO;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoEditHandler {

    private final BancoEditService bancoEditService;

    public BancoEditHandler(BancoEditService bancoEditService) {
        this.bancoEditService = bancoEditService;
    }

    public void execute(UUID uuid, ActualizarBancoDTO dto) {
        bancoEditService.execute(uuid, dto);
    }
}
