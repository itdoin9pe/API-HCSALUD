package com.saludsystem.submodules.principal.response;

import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AseguradoraListResponse {

    @Schema(description = "Lista de aseguradoras")
    private List<AseguradoraDTO> data;

    @Schema(description = "Número total de aseguradoras", example = "0")
    private long totalData;

}
