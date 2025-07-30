package com.saludsystem.submodules.operaciones.response;

import com.saludsystem.submodules.operaciones.dtos.query.TipoMaterialDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TipoMaterialListResponse {

    @Schema(description = "Lista de tipo materiales")
    private List<TipoMaterialDTO> data;

    @Schema(description = "Total de registros de Tipos de materiales", example = "0")
    private long totalData;

}