package com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.ProcedimientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class ProcedimientoResponse {

    @Schema(description = "Lita de procedimientos para tratamiento del paciente")
    private List<ProcedimientoDTO> data;

    @Schema(description = "Total de procedimientos para tratamiento del paciente", example = "0")
    private long totalData;

}