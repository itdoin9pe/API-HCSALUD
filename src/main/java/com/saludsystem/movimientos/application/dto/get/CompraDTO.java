package com.saludsystem.movimientos.application.dto.get;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompraDTO extends CrearCompraDTO {

    private UUID compraId;

}