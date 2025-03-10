package com.saludSystem.Catalogo.Medida.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class MedidaDTO {

    private UUID medidaId;

    private String nombre;

    @Schema(description = "Estado de la medida (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}