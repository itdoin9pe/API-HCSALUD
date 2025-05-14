package com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
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