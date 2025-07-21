package com.saludsystem.submodules.mantenimiento.response;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TarifarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TarifarioListResponse {

    @Schema(description = "Lista de Tarifarios")
    private List<TarifarioDTO> data;

    @Schema(description = "Numero total de tarifarios", example = "0")
    private long totalData;

}