package com.saludsystem.infrastructure.adapters.in.response.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.CajaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CajaResponse {

    @Schema(description = "Lista de Cajas")
    private List<CajaDTO> data;

    @Schema(description = "Número total de Cajas Registradas", example = "0")
    private long totalData;

}