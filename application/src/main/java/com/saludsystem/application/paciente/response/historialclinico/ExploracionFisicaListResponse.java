package com.saludsystem.application.paciente.response.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.ExploracionFisicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ExploracionFisicaListResponse {

    @Schema(description = "Lista de registros de exploraciones fisicas del paciente")
    private List<ExploracionFisicaDTO> data;

    @Schema(description = "Total de registros de exploraciones fisicas del paciente", example = "0")
    private long totalData;

}