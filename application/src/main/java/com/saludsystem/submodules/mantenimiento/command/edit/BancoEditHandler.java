package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.BancoEditCommand;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoEditHandler {

    private final BancoEditService bancoEditService;
    private final BancoMapper bancoMapper;

    public BancoEditHandler(BancoEditService bancoEditService, BancoMapper bancoMapper) {
        this.bancoEditService = bancoEditService;
        this.bancoMapper = bancoMapper;
    }

    public void execute(UUID uuid, BancoEditCommand editCommand) {

        var banco = bancoMapper.fromUpdateDto(uuid, editCommand);

        bancoEditService.execute(uuid, banco);

    }

}
