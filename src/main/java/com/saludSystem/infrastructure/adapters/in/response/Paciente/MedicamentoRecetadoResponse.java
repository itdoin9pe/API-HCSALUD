package com.saludSystem.infrastructure.adapters.in.response.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MedicamentoRecetadoResponse {

    @Schema(description = "Lista de medicamentos recetados registrados")
    private List<MedicamentoRecetadoDTO> data;

    @Schema(description = "Total de medicamentos recetados registrados")
    private long totalData;

}