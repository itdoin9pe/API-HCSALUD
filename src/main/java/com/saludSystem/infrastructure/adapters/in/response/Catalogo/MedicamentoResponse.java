package com.saludSystem.infrastructure.adapters.in.response.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MedicamentoResponse {
    @Schema(description = "Lista de registros para medicamentos")
    private List<MedicamentoDTO> data;
    @Schema(description = "Total de registros para medicamentos", example = "0")
    private long totalData;
}