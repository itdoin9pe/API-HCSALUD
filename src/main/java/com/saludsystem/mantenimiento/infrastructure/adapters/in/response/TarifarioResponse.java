package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import com.saludsystem.mantenimiento.application.dto.res.TarifarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TarifarioResponse {

    @Schema(description = "Lista de Tarifarios")
    private List<TarifarioDTO> data;

    @Schema(description = "Numero total de tarifarios", example = "0")
    private long totalData;

}