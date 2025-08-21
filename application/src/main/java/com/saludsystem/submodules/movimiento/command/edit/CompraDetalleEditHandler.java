package com.saludsystem.submodules.movimiento.command.edit;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraDetalleEditCommand;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleEditHandler {

    private final CompraDetalleRepository compraDetalleRepository;
    private final CompraDetalleMapper compraDetalleMapper;

    public CompraDetalleEditHandler(CompraDetalleRepository compraDetalleRepository, CompraDetalleMapper compraDetalleMapper) {
        this.compraDetalleRepository = compraDetalleRepository;
        this.compraDetalleMapper = compraDetalleMapper;
    }

    public void execute(UUID uuid, CompraDetalleEditCommand editCommand) {

        var compraDetalleUpdated = compraDetalleMapper.fromUpdateDto(uuid, editCommand);

        compraDetalleRepository.update(uuid, compraDetalleUpdated);

    }

}
