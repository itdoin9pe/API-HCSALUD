package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearApoderadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApoderadoListResponse {

    @Schema(description = "Lista de Apoderados")
    private List<CrearApoderadoDTO> data;

    @Schema(description = "Número total de Apoderados Registradas", example = "0")
    private long totalData;

}