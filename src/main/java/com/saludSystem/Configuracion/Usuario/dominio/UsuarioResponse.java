package com.saludSystem.Configuracion.Usuario.dominio;

import com.saludSystem.Configuracion.Usuario.aplicacion.dtos.UsuarioDTO;
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