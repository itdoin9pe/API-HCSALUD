package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearClienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteListResponse {

    @Schema(description = "Lista de Clientes")
    private List<CrearClienteDTO> data;

    @Schema(description = "Número total de Clientes Registradas", example = "0")
    private long totalData;

}