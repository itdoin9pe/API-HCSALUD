package com.saludsystem.infrastructure.adapters.in.response.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TarifarioDTO;
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