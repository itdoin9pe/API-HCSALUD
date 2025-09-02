package com.saludsystem.submodules.movimiento.mapper;

import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDTO;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaEditCommand;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VentaMapper {

    private final VentaDetalleMapper detalleMapper = new VentaDetalleMapper();

    public Venta fromCreateDto(VentaCreateCommand createCommand) {

        List<VentaDetalle> detalles = createCommand.getDetalles().stream()
                .map(detalleMapper::fromCreateDto)
                .collect(Collectors.toList());

        return new Venta(null, createCommand.getSerie(), createCommand.getSecuencia(), createCommand.getFecha(),
                createCommand.getTipoBeneficiario(), createCommand.getBeneficiarioDocumento(),
                createCommand.getBeneficiarioDireccion(), createCommand.getTipoPagoId(), createCommand.getObservacion(),
                createCommand.getMetodoPago(), createCommand.getMontoRecibido(), createCommand.getVuelto(),
                createCommand.getTotal(), createCommand.getTipoDocumentoId(), createCommand.getAlmacenId(),
                createCommand.getBeneficiarioId(), createCommand.getTipoTarjetaId(), createCommand.getTipoMonedaId(),
                createCommand.getEstado(), detalles);

    }

    public Venta fromUpdateDto(UUID uuid, VentaEditCommand editCommand) {

        List<VentaDetalle> detalles = editCommand.getDetalles().stream()
                .map(d -> detalleMapper.fromUpdateDto(d.getVentaDetalleId(), d))
                .collect(Collectors.toList());

        return new Venta(uuid, editCommand.getSerie(), editCommand.getSecuencia(), editCommand.getFecha(),
                editCommand.getTipoBeneficiario(), editCommand.getBeneficiarioDocumento(),
                editCommand.getBeneficiarioDireccion(), editCommand.getTipoPagoId(), editCommand.getObservacion(),
                editCommand.getMetodoPago(), editCommand.getMontoRecibido(), editCommand.getVuelto(),
                editCommand.getTotal(), editCommand.getTipoDocumentoId(), editCommand.getAlmacenId(),
                editCommand.getBeneficiarioId(), editCommand.getTipoTarjetaId(), editCommand.getTipoMonedaId(),
                editCommand.getEstado(), detalles);

    }

    public VentaDTO toDto(Venta model) {

        return new VentaDTO(
                model.getVentaId(),
                model.getSerie(),
                model.getSecuencia(),
                model.getFecha(),
                model.getTipoBeneficiario(),
                model.getBeneficiarioDocumento(),
                model.getBeneficiarioDireccion(),
                model.getTipoPagoId(),
                model.getObservacion(),
                model.getMetodoPago(),
                model.getMontoRecibido(),
                model.getVuelto(),
                model.getTotal(),
                model.getTipoDocumentoId(),
                model.getAlmacenId(),
                model.getBeneficiarioId(),
                model.getTipoTarjetaId(),
                model.getTipoMonedaId(),
                model.getEstado(),
                model.getDetalles()
                        .stream()
                        .map(detalleMapper::toDto)
                        .collect(Collectors.toList()));

    }

}
