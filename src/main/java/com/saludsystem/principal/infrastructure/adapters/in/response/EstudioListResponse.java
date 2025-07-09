package com.saludsystem.principal.infrastructure.adapters.in.response;

import com.saludsystem.principal.application.dto.get.EstudioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstudioListResponse {

    @Schema(description = "Lista de Estudios")
    private List<EstudioDTO> data;

    @Schema(description = "Numero total de estudios formativos", example = "0")
    private long totalData;

}