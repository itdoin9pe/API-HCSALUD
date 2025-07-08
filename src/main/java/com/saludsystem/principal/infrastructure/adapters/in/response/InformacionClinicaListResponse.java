package com.saludsystem.principal.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class InformacionClinicaListResponse {

    @Schema(description = "Lista de Informaciones Clinicas")
    private List<com.saludsystem.principal.application.dto.res.InformacionClinicaResponse> data;

    @Schema(description = "Número total de Informaciones Clinicas", example = "0")
    private long totalData;

}