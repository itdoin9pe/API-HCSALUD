package com.saludsystem.infrastructure.adapters.in.response.paciente;

import com.saludsystem.application.dtos.paciente.get.MedicamentoRecetadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class MedicamentoRecetadoResponse {

    @Schema(description = "Lista de medicamentos recetados registrados")
    private List<MedicamentoRecetadoDTO> data;

    @Schema(description = "Total de medicamentos recetados registrados", example = "0")
    private long totalData;

}