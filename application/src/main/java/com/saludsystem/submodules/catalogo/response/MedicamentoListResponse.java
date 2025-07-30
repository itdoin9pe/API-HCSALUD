package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MedicamentoListResponse {
    @Schema(description = "Lista de registros para medicamentos")
    private List<MedicamentoCreateCommand> data;
    @Schema(description = "Total de registros para medicamentos", example = "0")
    private long totalData;
}