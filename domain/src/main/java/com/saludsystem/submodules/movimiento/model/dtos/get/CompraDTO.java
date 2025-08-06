package com.saludsystem.submodules.movimiento.dtos.get;

import com.saludsystem.submodules.movimiento.dtos.post.CrearCompraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDTO extends CrearCompraDTO {

    private UUID compraId;

}