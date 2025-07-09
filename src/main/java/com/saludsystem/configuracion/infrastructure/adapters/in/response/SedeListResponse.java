package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import com.saludsystem.configuracion.application.dto.get.SedeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class SedeListResponse {

    @Schema(description = "Lista de Sedes")
    private List<SedeDTO> data;

    @Schema(description = "Número total de Sedes", example = "0")
    private long totalData;

}