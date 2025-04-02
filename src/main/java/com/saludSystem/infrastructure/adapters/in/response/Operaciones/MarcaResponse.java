package com.saludSystem.infrastructure.adapters.in.response.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MarcaResponse {

    @Schema(description = "Lista de marcas registradas")
    private List<MarcaDTO> data;

    @Schema(description = "Total de marcas registradas", example = "0")
    private long totalData;

}