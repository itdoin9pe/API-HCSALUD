package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import com.saludsystem.mantenimiento.application.dto.res.CuentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CuentaResponse {

    @Schema(description = "Lista de Alergias")
    private List<CuentaDTO> data;

    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;

}