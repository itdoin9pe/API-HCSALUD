package com.saludSystem.infrastructure.adapters.in.response.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.SedeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class SedeResponse {

    @Schema(description = "Lista de Sedes")
    private List<SedeDTO> data;

    @Schema(description = "Número total de Sedes", example = "0")
    private long totalData;

}