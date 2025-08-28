package com.saludsystem.submodules.movimiento.mapper;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.model.dtos.InventarioDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.InventarioCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.InventarioEditCommand;

import java.util.UUID;

public class InventarioMapper {

    public Inventario fromCreateDto(InventarioCreateCommand createCommand) {
        return new Inventario(null, createCommand.getProductoId(), createCommand.getAlmacenId(),
                createCommand.getTipoInventarioId(), createCommand.getMarcaMaterialId(),
                createCommand.getCategoriaMaterialId(), createCommand.getUnidadId(),
                createCommand.getPrecioEntrada(), createCommand.getPrecioSalida(), createCommand.getStock(),
                createCommand.getFecha(), createCommand.getEstado());
    }

    public Inventario fromUpdateDto(UUID uuid, InventarioEditCommand editCommand) {
        return new Inventario(uuid, editCommand.getProductoId(), editCommand.getAlmacenId(),
                editCommand.getTipoInventarioId(), editCommand.getMarcaMaterialId(),
                editCommand.getCategoriaMaterialId(), editCommand.getUnidadId(), editCommand.getPrecioEntrada(),
                editCommand.getPrecioSalida(), editCommand.getStock(), editCommand.getFecha(),
                editCommand.getEstado());
    }

    public InventarioDTO toDto(Inventario model) {
        return new InventarioDTO(model.getId(), model.getProductoId(), model.getAlmacenId(),
                model.getTipoInventarioId(), model.getMarcaId(),
                model.getCategoriaId(), model.getUnidadId(), model.getPrecioEntrada(),
                model.getPrecioSalida(), model.getStock(), model.getFecha(),
                model.getEstado());
    }

}