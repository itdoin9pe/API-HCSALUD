package com.saludsystem.infrastructure.adapters.in.response.principal;

import com.saludsystem.application.dtos.principal.get.InformacionClinicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class InformacionClinicaResponse {

    @Schema(description = "Lista de Informaciones Clinicas")
    private List<InformacionClinicaDTO> data;

    @Schema(description = "Número total de Informaciones Clinicas", example = "0")
    private long totalData;

}