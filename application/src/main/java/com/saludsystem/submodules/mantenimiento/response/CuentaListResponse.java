package com.saludsystem.submodules.mantenimiento.response;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.CuentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CuentaListResponse {

    @Schema(description = "Lista de Alergias")
    private List<CuentaDTO> data;

    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;

}