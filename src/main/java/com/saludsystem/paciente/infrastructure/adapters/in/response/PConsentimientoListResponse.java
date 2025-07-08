package com.saludsystem.paciente.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PConsentimientoListResponse {

    @Schema(description = "Lista de consentimientos del paciente")
    private List<com.saludsystem.paciente.application.dto.res.PConsentimientoResponse> data;

    @Schema(description = "Total de registos para el consentimiento del paciente", example = "0")
    private long totalData;

}