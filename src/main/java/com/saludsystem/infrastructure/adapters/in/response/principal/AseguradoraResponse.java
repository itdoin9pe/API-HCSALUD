package com.saludsystem.infrastructure.adapters.in.response.principal;

import com.saludsystem.application.dtos.principal.get.AseguradoraDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AseguradoraResponse {

    @Schema(description = "Lista de aseguradoras")
    private List<AseguradoraDTO> data;

    @Schema(description = "Número total de aseguradoras", example = "0")
    private long totalData;

}
