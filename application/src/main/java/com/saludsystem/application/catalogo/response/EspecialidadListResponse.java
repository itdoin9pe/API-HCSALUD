package com.saludsystem.application.catalogo.response;

import com.saludsystem.application.catalogo.dtos.get.EspecialidadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EspecialidadListResponse {

    @Schema(description = "Lista de Especialidades")
    private List<EspecialidadDTO> data;

    @Schema(description = "Número total de Especialidades", example = "0")
    private long totalData;

}