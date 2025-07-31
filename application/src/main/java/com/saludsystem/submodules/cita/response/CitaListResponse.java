package com.saludsystem.submodules.cita.response;

import com.saludsystem.submodules.cita.model.dtos.command.CitaCreateCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CitaListResponse {

    @Schema(description = "Lista de registros de citas")
    private List<CitaCreateCommand> data;

    @Schema(description = "Total de registros para citas", example = "0")
    private long totalData;

}