package com.saludsystem.application.movimiento.dtos.get;

import com.saludsystem.application.movimiento.dtos.post.CrearCompraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDTO extends CrearCompraDTO {

    private UUID compraId;

}