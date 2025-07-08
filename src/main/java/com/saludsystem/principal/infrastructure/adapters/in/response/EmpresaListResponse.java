package com.saludsystem.principal.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmpresaListResponse {

    @Schema(description = "Lista de Empresas")
    private List<com.saludsystem.principal.application.dto.res.EmpresaResponse> data;

    @Schema(description = "Número total de Empresas", example = "0")
    private long totalData;

}
