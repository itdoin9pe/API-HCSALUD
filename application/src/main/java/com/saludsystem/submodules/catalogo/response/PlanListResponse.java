package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.dtos.get.PlanDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PlanListResponse {

    @Schema(description = "Lista de Planes")
    private List<PlanDTO> data;

    @Schema(description = "Número total de Planes", example = "0")
    private long totalData;

}