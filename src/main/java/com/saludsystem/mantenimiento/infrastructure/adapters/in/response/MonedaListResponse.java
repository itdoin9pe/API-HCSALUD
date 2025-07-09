package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import com.saludsystem.mantenimiento.application.dto.get.MonedaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MonedaListResponse {

    @Schema(description = "Lista de Tipo de Monedas")
    private List<MonedaDTO> data;

    @Schema(description = "Número total de Tipos de Monedas", example = "0")
    private long totalData;

}