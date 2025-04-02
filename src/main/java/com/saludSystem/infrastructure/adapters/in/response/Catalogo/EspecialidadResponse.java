package com.saludSystem.infrastructure.adapters.in.response.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.EspecialidadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EspecialidadResponse {

    @Schema(description = "Lista de Especialidades")
    private List<EspecialidadDTO> data;

    @Schema(description = "Número total de Especialidades", example = "0")
    private long totalData;

}