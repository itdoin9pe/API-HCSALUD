package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import com.saludsystem.mantenimiento.application.dto.get.EnfermedadDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnfermedadListResponse {

    @Schema(description = "Lista de Enfermedades")
    private List<EnfermedadDTO> data;

    @Schema(description = "Numero total de enfermedades registrados", example = "0")
    private long totalData;

}