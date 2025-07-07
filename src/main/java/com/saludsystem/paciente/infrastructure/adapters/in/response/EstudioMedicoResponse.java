package com.saludsystem.paciente.infrastructure.adapters.in.response;

import com.saludsystem.paciente.application.dto.res.EstudioMedicoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstudioMedicoResponse {

    @Schema(description = "Lista de registros para estudios medicos del paciente")
    private List<EstudioMedicoDTO> data;

    @Schema(description = "Total de registros para estudios medicos del paciente", example = "0")
    private long totalData;

}