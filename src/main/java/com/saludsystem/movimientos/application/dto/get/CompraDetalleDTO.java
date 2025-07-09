package com.saludsystem.movimientos.application.dto.get;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDetalleDTO extends CrearCompraDetalleDTO {

    private UUID compraDetalleId;

}