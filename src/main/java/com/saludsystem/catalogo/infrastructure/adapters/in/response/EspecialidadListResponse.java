package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearEspecialidadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EspecialidadListResponse {

    @Schema(description = "Lista de Especialidades")
    private List<CrearEspecialidadDTO> data;

    @Schema(description = "Número total de Especialidades", example = "0")
    private long totalData;

}