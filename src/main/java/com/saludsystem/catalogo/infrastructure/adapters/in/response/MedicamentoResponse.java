package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.res.MedicamentoDTO;
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