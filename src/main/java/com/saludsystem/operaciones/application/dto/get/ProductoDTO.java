package com.saludsystem.operaciones.application.dto.get;

import com.saludsystem.operaciones.application.dto.post.CrearProductoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductoDTO extends CrearProductoDTO {

    private UUID productoId;

}