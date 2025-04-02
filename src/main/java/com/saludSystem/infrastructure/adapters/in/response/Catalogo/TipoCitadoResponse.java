package com.saludSystem.infrastructure.adapters.in.response.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.TipoCitadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoCitadoResponse {

    @Schema(description = "Lista de Estados de cita")
    private List<TipoCitadoDTO> data;

    @Schema(description = "Número total de Estados de cita", example = "0")
    private long totalData;

}
