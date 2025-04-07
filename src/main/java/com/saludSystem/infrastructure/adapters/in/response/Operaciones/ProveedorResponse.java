package com.saludSystem.infrastructure.adapters.in.response.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProveedorResponse {

    @Schema(description = "Lista de proveedores")
    private List<ProveedorDTO> data;

    @Schema(description = "Total de proveedores", example = "0")
    private long totalData;

}