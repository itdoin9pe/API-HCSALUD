package com.saludsystem.infrastructure.adapters.in.response.paciente;

import com.saludsystem.application.dtos.paciente.get.PConsentimientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PConsentimientoResponse {

    @Schema(description = "Lista de consentimientos del paciente")
    private List<PConsentimientoDTO> data;

    @Schema(description = "Total de registos para el consentimiento del paciente", example = "0")
    private long totalData;

}