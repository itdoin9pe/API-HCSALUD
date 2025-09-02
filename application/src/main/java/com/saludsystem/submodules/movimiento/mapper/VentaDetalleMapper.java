package com.saludsystem.submodules.movimiento.mapper;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDetalleDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaDetalleEditCommand;

import java.util.UUID;

public class VentaDetalleMapper {
	
    public VentaDetalle fromCreateDto(VentaDetalleCreateCommand createCommand) {
        return new VentaDetalle(null,
                createCommand.getProductoId(),
        		createCommand.getVentaId(),
                createCommand.getCodigoProducto(),
                createCommand.getCantidad(),
                createCommand.getPrecioUnitario(),
                createCommand.getSubtotal());
    }

    public VentaDetalle fromUpdateDto(UUID uuid, VentaDetalleEditCommand editCommand) {
        return new VentaDetalle(null,
                editCommand.getProductoId(),
        		editCommand.getVentaId(),
                editCommand.getCodigoProducto(),
                editCommand.getCantidad(),
                editCommand.getPrecioUnitario(),
                editCommand.getSubtotal());
    }

    public VentaDetalleDTO toDto(VentaDetalle model) {
        return new VentaDetalleDTO(model.getVentaDetalleId(),
                model.getProductoId(),
        		model.getVentaId(),
                model.getCodigoProducto(),
                model.getCantidad(),
                model.getPrecioUnitario().doubleValue(),
                model.getSubtotal().doubleValue());
    }
    
}
