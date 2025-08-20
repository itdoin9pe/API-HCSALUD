package com.saludsystem.submodules.movimiento.command.edit;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraEditCommand;
import com.saludsystem.submodules.movimiento.service.compra.CompraEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraEditHandler {

    private final CompraEditService compraEditService;
    private final CompraMapper compraMapper;

    public CompraEditHandler(CompraEditService compraEditService, CompraMapper compraMapper) {
        this.compraEditService = compraEditService;
        this.compraMapper = compraMapper;
    }

    public void execute(UUID uuid, CompraEditCommand editCommand) {

        var compraUpdated = compraMapper.fromUpdateDto(uuid, editCommand);

        compraEditService.execute(uuid, compraUpdated);

    }

}
