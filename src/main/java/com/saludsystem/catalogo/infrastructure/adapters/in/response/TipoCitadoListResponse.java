package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearTipoCitadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoCitadoListResponse {

    @Schema(description = "Lista de Estados de cita")
    private List<CrearTipoCitadoDTO> data;

    @Schema(description = "Número total de Estados de cita", example = "0")
    private long totalData;

}
