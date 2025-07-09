package com.saludsystem.principal.infrastructure.adapters.in.response;

import com.saludsystem.principal.application.dto.get.EmpresaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmpresaListResponse {

    @Schema(description = "Lista de Empresas")
    private List<EmpresaDTO> data;

    @Schema(description = "Número total de Empresas", example = "0")
    private long totalData;

}
