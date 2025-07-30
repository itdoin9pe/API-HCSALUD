package com.saludsystem.submodules.operaciones.dtos.query;

import com.saludsystem.submodules.operaciones.dtos.command.CrearProductoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductoDTO extends CrearProductoDTO {

    private UUID productoId;

}