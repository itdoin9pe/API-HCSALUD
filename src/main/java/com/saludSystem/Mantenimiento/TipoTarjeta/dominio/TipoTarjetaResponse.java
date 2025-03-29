package com.saludSystem.Mantenimiento.TipoTarjeta.dominio;

import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.TipoTarjetaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoTarjetaResponse {

    @Schema(description = "Lista de Tipo de tarjetas")
    private List<TipoTarjetaDTO> data;

    @Schema(description = "Número total de tipos de tarjetas", example = "0")
    private long totalData;

}