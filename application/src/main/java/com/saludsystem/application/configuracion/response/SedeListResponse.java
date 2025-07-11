package com.saludsystem.application.configuracion.response;

import com.configuracion.application.dto.get.SedeDTO;
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