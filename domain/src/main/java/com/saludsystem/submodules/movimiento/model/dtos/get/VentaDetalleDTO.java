package com.saludsystem.submodules.movimiento.model.dtos.get;

import com.saludsystem.submodules.movimiento.model.dtos.post.CrearVentaDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class VentaDetalleDTO extends CrearVentaDetalleDTO {

    private UUID ventaDetalleId;

}