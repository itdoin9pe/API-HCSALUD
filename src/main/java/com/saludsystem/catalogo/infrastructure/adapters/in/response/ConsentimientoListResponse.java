package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsentimientoListResponse {

    @Schema(description = "Lista de Consentimientos")
    private List<ConsentimientoRequest> data;

    @Schema(description = "Número total de Consentimientos Registradas", example = "0")
    private long totalData;

}