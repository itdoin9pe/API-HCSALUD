package com.saludSystem.Catalogo.Plan.dominio;

import com.saludSystem.Catalogo.Plan.aplicacion.dtos.PlanDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanResponse {

    @Schema(description = "Lista de Planes")
    private List<PlanDTO> data;

    @Schema(description = "Número total de Planes", example = "0")
    private long totalData;

}