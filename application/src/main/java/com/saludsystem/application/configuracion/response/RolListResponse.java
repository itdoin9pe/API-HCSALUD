package com.saludsystem.application.configuracion.response;

import com.configuracion.application.dto.get.RolDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class RolListResponse {

    @Schema(description = "Lista de Roles")
    private List<RolDTO> data;

    @Schema(description = "Número total de Roles", example = "0")
    private long totalData;

}