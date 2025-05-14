package com.saludSystem.infrastructure.adapters.in.response.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsentimientoResponse {

    @Schema(description = "Lista de Consentimientos")
    private List<ConsentimientoDTO> data;

    @Schema(description = "Número total de Consentimientos Registradas", example = "0")
    private long totalData;

}