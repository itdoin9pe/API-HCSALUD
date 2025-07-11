package com.saludsystem.application.catalogo.response;

import com.saludsystem.application.catalogo.dtos.get.TipoCitadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoCitadoListResponse {

    @Schema(description = "Lista de Estados de cita")
    private List<TipoCitadoDTO> data;

    @Schema(description = "Número total de Estados de cita", example = "0")
    private long totalData;

}
