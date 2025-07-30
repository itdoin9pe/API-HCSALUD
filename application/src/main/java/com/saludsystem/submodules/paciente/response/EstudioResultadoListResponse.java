package com.saludsystem.submodules.paciente.response;

import com.saludsystem.submodules.paciente.dtos.get.EstudioResultadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstudioResultadoListResponse {

    @Schema(description = "Lista de registros sobre resultado medicos de los estudios del paciente")
    private List<EstudioResultadoDTO> data;

    @Schema(description = "Total de todos registros sobre resultado medicos de los estudios del paciente", example = "0")
    private long totalData;

}