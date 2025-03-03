package com.saludSystem.aplicacion.responses.Configuracion;

import com.saludSystem.aplicacion.dtos.Configuracion.Rol.RolDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class RolResponse {

    @Schema(description = "Lista de Roles")
    private List<RolDTO> data;

    @Schema(description = "Número total de Roles", example = "0")
    private long totalData;

}