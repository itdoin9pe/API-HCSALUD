package com.saludSystem.infrastructure.adapters.in.response.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.EstudioMedicoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstudioMedicoResponse {

    @Schema(description = "Lista de registros para estudios medicos del paciente")
    private List<EstudioMedicoDTO> data;

    @Schema(description = "Total de registros para estudios medicos del paciente", example = "0")
    private long totalData;

}