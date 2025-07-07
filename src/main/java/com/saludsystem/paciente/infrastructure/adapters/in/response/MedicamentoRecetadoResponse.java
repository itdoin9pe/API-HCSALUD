package com.saludsystem.paciente.infrastructure.adapters.in.response;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoDTO;
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