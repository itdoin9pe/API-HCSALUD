package com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearTipoCitadoDTO {

    private String nombre;

    private String color;

    @Schema(description = "Estado del Tipo Citado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
