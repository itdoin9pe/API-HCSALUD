package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EspecialidadListResponse {

    @Schema(description = "Lista de Especialidades")
    private List<EspecialidadCreateCommand> data;

    @Schema(description = "Número total de Especialidades", example = "0")
    private long totalData;

}