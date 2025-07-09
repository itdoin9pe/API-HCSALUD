package com.saludsystem.movimientos.application.dto.get;

import com.saludsystem.movimientos.application.dto.post.CrearVentaDetalleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class VentaDetalleDTO extends CrearVentaDetalleDTO {

    private UUID vemtaDetalleId;

}