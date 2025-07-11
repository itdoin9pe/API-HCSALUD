package com.saludsystem.application.operaciones.dtos.get;

import com.saludsystem.application.dto.post.CrearProductoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductoDTO extends CrearProductoDTO {

    private UUID productoId;

}