package com.saludSystem.infrastructure.adapters.in.response.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PermisoResponse {

    @Schema(description = "Lista de Permisos")
    private List<PermisoDTO> data;

    @Schema(description = "Número total de Permisos", example = "0")
    private long totalData;

}