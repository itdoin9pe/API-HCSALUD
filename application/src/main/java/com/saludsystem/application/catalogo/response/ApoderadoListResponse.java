package com.saludsystem.application.catalogo.response;

import com.saludsystem.application.catalogo.dtos.get.ApoderadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApoderadoListResponse {

    @Schema(description = "Lista de Apoderados")
    private List<ApoderadoDTO> data;

    @Schema(description = "Número total de Apoderados Registradas", example = "0")
    private long totalData;

}