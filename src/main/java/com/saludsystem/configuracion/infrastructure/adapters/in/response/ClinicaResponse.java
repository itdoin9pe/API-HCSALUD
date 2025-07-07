package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import com.saludsystem.configuracion.application.dto.req.SysSaludDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClinicaResponse {

    @Schema(description = "Lista de Sedes")
    private List<SysSaludDTO> data;

    @Schema(description = "Número total de Sedes", example = "0")
    private long totalData;

}