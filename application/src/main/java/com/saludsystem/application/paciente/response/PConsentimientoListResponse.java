package com.saludsystem.application.paciente.response;

import com.saludsystem.application.dto.get.PConsentimientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PConsentimientoListResponse {

    @Schema(description = "Lista de consentimientos del paciente")
    private List<PConsentimientoDTO> data;

    @Schema(description = "Total de registos para el consentimiento del paciente", example = "0")
    private long totalData;

}