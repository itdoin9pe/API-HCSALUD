package com.saludSystem.aplicacion.dtos.responses.Configuracion;

import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.PermisoDTO;
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