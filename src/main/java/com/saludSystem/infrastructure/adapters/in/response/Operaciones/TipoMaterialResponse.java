package com.saludSystem.infrastructure.adapters.in.response.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TipoMaterialResponse {

    @Schema(description = "Lista de tipo materiales")
    private List<TipoMaterialDTO> data;

    @Schema(description = "Total de registros de Tipos de materiales", example = "0")
    private long totalData;

}