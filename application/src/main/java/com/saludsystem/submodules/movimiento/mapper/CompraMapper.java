package com.saludsystem.submodules.movimiento.mapper;

import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraEditCommand;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CompraMapper {

    private final CompraDetalleMapper detalleMapper = new CompraDetalleMapper();

    public Compra fromCreateDto(CompraCreateCommand createCommand) {
        List<CompraDetalle> detalles = createCommand.getDetalles().stream()
                .map(d -> detalleMapper.fromCreateDto(null, d)) // el compraId aún no existe
                .collect(Collectors.toList());

        return new Compra(
                null,
                createCommand.getFecha(),
                createCommand.getTipoDocumento(),
                createCommand.getNroDocumento(),
                createCommand.getProveedorId(),
                createCommand.getTipoPagoId(),
                createCommand.getAlmacenId(),
                createCommand.getEfectivo(),
                createCommand.getGuiaRemision(),
                createCommand.getObservacion(),
                createCommand.getEstado(),
                detalles
        );
    }

    public Compra fromUpdateDto(UUID id, CompraEditCommand editCommand) {
        List<CompraDetalle> detalles = editCommand.getDetalles().stream()
                .map(d -> detalleMapper.fromUpdateDto(d.getCompraDetalleId(), id, d))
                .collect(Collectors.toList());

        return new Compra(
                id,
                editCommand.getFecha(),
                editCommand.getTipoDocumento(),
                editCommand.getNroDocumento(),
                editCommand.getProveedorId(),
                editCommand.getTipoPagoId(),
                editCommand.getAlmacenId(),
                editCommand.getEfectivo(),
                editCommand.getGuiaRemision(),
                editCommand.getObservacion(),
                editCommand.getEstado(),
                detalles
        );
    }

    public CompraDTO toDto(Compra model) {
        return new CompraDTO(
                model.getCompraId(),
                model.getFecha(),
                model.getTipoDocumento(),
                model.getNroDocumento(),
                model.getProveedorId(),
                model.getTipoPagoId(),
                model.getAlmacenId(),
                model.getEfectivoTotal(),
                model.getGuiaRemision(),
                model.getObservacion(),
                model.getEstado(),
                model.getDetalles().stream()
                        .map(detalleMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

}
