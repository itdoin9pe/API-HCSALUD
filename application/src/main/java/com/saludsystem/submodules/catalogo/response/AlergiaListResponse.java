package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlergiaListResponse {
    @Schema(description = "Lista de Alergias")
    private List<AlergiaDTO> data;
    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;
}