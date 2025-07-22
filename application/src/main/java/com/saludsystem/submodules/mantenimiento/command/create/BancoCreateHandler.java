package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearBancoDTO;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoCreateService;
import org.springframework.stereotype.Component;

@Component
public class BancoCreateHandler {

    private final BancoCreateService bancoCreateService;

    public BancoCreateHandler(BancoCreateService bancoCreateService) {
        this.bancoCreateService = bancoCreateService;
    }

    public void execute(CrearBancoDTO dto) {
        bancoCreateService.execute(dto);
    }
}
