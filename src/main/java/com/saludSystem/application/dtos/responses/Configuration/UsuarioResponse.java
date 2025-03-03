package com.saludSystem.application.dtos.responses.Configuration;

import com.saludSystem.application.dtos.configuration.User.UsuarioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioResponse {

    @Schema(description = "Lista de Usuarios")
    private List<UsuarioDTO> data;

    @Schema(description = "Número total de Usuarios", example = "0")
    private long totalData;

}