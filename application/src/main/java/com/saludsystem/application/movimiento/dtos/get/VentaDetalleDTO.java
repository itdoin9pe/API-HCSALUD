package com.saludsystem.application.movimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearVentaDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class VentaDetalleDTO extends CrearVentaDetalleDTO {

    private UUID ventaDetalleId;

}