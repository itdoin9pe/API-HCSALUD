package com.saludsystem.submodules.movimiento.dtos.get;

import com.saludsystem.submodules.movimiento.dtos.post.CrearCompraDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDetalleDTO extends CrearCompraDetalleDTO {

    private UUID compraDetalleId;

}