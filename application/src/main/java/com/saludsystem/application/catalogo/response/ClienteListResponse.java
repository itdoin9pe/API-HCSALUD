package com.saludsystem.application.catalogo.response;

import com.saludsystem.application.catalogo.dtos.get.ClienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteListResponse {

    @Schema(description = "Lista de Clientes")
    private List<ClienteDTO> data;

    @Schema(description = "Número total de Clientes Registradas", example = "0")
    private long totalData;

}