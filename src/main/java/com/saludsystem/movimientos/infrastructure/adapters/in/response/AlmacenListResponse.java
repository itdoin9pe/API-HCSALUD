package com.saludsystem.movimientos.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class AlmacenListResponse {

    @Schema(description = "Lista de alamacenes")
    private List<com.saludsystem.movimientos.application.dto.res.AlmacenResponse> data;

    @Schema(description = "Total de almacences", example = "0")
    private long totalData;

}