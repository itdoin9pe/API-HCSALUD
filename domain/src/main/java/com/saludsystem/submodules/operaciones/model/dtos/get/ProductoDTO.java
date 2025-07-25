package com.saludsystem.submodules.operaciones.model.dtos.get;

import com.saludsystem.submodules.operaciones.model.dtos.post.CrearProductoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductoDTO extends CrearProductoDTO {

    private UUID productoId;

}