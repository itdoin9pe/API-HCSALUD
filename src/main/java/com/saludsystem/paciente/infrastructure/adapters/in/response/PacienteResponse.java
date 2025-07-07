package com.saludsystem.paciente.infrastructure.adapters.in.response;

import com.saludsystem.paciente.application.dto.res.PacienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PacienteResponse {

    @Schema(description = "Lista de Pacientes")
    private List<PacienteDTO> data;

    @Schema(description = "Número total de Paciemtes", example = "0")
    private long totalData;

}