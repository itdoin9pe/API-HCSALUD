package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearPlanDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PlanListResponse {

    @Schema(description = "Lista de Planes")
    private List<CrearPlanDTO> data;

    @Schema(description = "Número total de Planes", example = "0")
    private long totalData;

}