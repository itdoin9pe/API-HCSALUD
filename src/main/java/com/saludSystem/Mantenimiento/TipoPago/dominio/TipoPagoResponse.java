package com.saludSystem.Mantenimiento.TipoPago.dominio;

import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.TipoPagoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoPagoResponse {

    @Schema(description = "Lista de tipos de pago")
    private List<TipoPagoDTO> data;

    @Schema(description = "Número total de tipos de pago", example = "0")
    private long totalData;

}