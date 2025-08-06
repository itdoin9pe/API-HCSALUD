package com.saludsystem.submodules.movimiento.response;

import com.saludsystem.submodules.movimiento.model.dtos.command.CompraCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CompraListResponse {

    @Schema(description = "Lista de registos de compras")
    private List<CompraCreateCommand> data;

    @Schema(description = "Total de registro de compras", example = "0")
    private long totalData;

}