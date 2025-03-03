package com.saludSystem.application.dtos.responses.Configuracion;

import com.saludSystem.application.dtos.Configuracion.SysSalud.SysSaludDTO;
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