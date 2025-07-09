package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.post.CrearMedicamentoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MedicamentoListResponse {
    @Schema(description = "Lista de registros para medicamentos")
    private List<CrearMedicamentoDTO> data;
    @Schema(description = "Total de registros para medicamentos", example = "0")
    private long totalData;
}