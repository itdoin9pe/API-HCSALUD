package com.saludsystem.submodules.movimiento.model.dtos.get;

import com.saludsystem.submodules.movimiento.model.dtos.post.CrearCompraDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDetalleDTO extends CrearCompraDetalleDTO {

    private UUID compraDetalleId;

}