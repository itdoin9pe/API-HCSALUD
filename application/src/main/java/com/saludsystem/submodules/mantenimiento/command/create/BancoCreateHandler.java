package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.BancoCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoCreateService;
import org.springframework.stereotype.Component;

@Component
public class BancoCreateHandler {

    private final BancoCreateService bancoCreateService;
    private final BancoMapper bancoMapper;

    public BancoCreateHandler(BancoCreateService bancoCreateService, BancoMapper bancoMapper) {
        this.bancoCreateService = bancoCreateService;
        this.bancoMapper = bancoMapper;
    }

    public void execute(BancoCreateCommand createCommand) {

        var banco = bancoMapper.fromCreateDto(createCommand);

        bancoCreateService.execute(banco);

    }

}
