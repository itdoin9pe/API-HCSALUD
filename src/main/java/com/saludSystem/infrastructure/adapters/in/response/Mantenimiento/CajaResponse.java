package com.saludSystem.infrastructure.adapters.in.response.Mantenimiento;

import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
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