package com.saludsystem.submodules.movimiento.model.dtos.get;

import com.saludsystem.submodules.movimiento.model.dtos.post.CrearCompraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDTO extends CrearCompraDTO {

    private UUID compraId;

}