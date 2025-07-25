package com.saludsystem.submodules.paciente.response;

import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RecetaListResponse {

    @Schema(description = "Lista de registros para recetas del paciente")
    private List<RecetaDTO> data;

    @Schema(description = "Total de registros para recetas del paciente", example = "0")
    private long totalData;

}