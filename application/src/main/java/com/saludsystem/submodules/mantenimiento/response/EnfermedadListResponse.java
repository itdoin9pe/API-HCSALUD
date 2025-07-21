package com.saludsystem.submodules.mantenimiento.response;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.EnfermedadDTO;
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