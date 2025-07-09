package com.saludsystem.operaciones.infrastructure.adapters.in.response;

import com.saludsystem.operaciones.application.dto.get.ProveedorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProveedorListResponse {

    @Schema(description = "Lista de proveedores")
    private List<ProveedorDTO> data;

    @Schema(description = "Total de proveedores", example = "0")
    private long totalData;

}