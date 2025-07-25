package com.saludsystem.submodules.paciente.response;

import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PacienteListResponse {

    @Schema(description = "Lista de Pacientes")
    private List<PacienteDTO> data;

    @Schema(description = "Número total de Paciemtes", example = "0")
    private long totalData;

}