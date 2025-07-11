package com.saludsystem.application.operaciones.response;

import com.saludsystem.operaciones.application.dto.get.UnidadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UnidadListResponse {

    @Schema(description = "Lista de unidades")
    private List<UnidadDTO> data;

    @Schema(description = "Numero total de unidades", example = "0")
    private long totalData;

}