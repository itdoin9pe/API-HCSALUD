package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class PresentacionListResponse {

    @Schema(description = "Lista de presentaciones")
    private List<com.saludsystem.operaciones.application.dto.res.PresentacionResponse> data;

    @Schema(description = "Total de registros de Presentacion", example = "0")
    private long totalData;

}