package com.saludSystem.Operaciones.Marca.dominio;

import com.saludSystem.Operaciones.Marca.aplicacion.dtos.MarcaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MarcaResponse {

    @Schema(description = "Lista de marcas registradas")
    private List<MarcaDTO> data;

    @Schema(description = "Total de marcas registradas", example = "0")
    private long totalData;

}