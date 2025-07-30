package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsentimientoListResponse {

    @Schema(description = "Lista de Consentimientos")
    private List<ConsentimientoCreateCommand> data;

    @Schema(description = "Número total de Consentimientos Registradas", example = "0")
    private long totalData;

}