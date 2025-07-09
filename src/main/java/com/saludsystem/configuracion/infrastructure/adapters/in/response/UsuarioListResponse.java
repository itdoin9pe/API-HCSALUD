package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import com.saludsystem.configuracion.application.dto.get.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioListResponse {

    @Schema(description = "Lista de Usuarios")
    private List<UsuarioDTO> data;

    @Schema(description = "Número total de Usuarios", example = "0")
    private long totalData;

}