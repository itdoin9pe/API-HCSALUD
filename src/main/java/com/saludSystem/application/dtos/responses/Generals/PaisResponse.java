package com.saludSystem.application.dtos.responses.Generals;

import com.saludSystem.application.dtos.Generals.Pais.PaisDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaisResponse {

    @Schema(description = "Lista de Paises")
    private List<PaisDTO> data;

    @Schema(description = "Numero total de Paises", example = "0")
    private long totalData;

}