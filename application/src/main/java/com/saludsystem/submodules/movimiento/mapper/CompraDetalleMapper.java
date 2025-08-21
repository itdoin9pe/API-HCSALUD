package com.saludsystem.submodules.movimiento.mapper;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDetalleDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraDetalleEditCommand;

import java.util.UUID;

public class CompraDetalleMapper {

    public CompraDetalle fromCreateDto(CompraDetalleCreateCommand createCommand) {
        return new CompraDetalle(null,
                createCommand.getCompraId(),
                createCommand.getProductoId(),
                createCommand.getCantidad(),
                createCommand.getPrecioUnitario(),
                createCommand.getIgv(),
                createCommand.getPrecioVenta(),
                createCommand.getSubtotal()
        );
    }

    public CompraDetalle fromUpdateDto(UUID id, CompraDetalleEditCommand editCommand) {
        return new CompraDetalle(id,
                editCommand.getCompraId(),
                editCommand.getProductoId(),
                editCommand.getCantidad(),
                editCommand.getPrecioUnitario(),
                editCommand.getIgv(),
                editCommand.getPrecioVenta(),
                editCommand.getSubtotal()
        );
    }

    public CompraDetalleDTO toDto(CompraDetalle model) {
        return new CompraDetalleDTO(
                model.getCompraDetalleId(),
                model.getCompraId(),
                model.getProductoId(),
                model.getCantidad(),
                model.getPrecioUnitario(),
                model.getIgv(),
                model.getPrecioVenta(),
                model.getSubtotal()
        );
    }

}
