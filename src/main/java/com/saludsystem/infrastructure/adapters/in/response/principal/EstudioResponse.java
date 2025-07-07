package com.saludsystem.infrastructure.adapters.in.response.principal;

import com.saludsystem.application.dtos.principal.res.EstudioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstudioResponse {

    @Schema(description = "Lista de Estudios")
    private List<EstudioDTO> data;

    @Schema(description = "Numero total de estudios formativos", example = "0")
    private long totalData;

}