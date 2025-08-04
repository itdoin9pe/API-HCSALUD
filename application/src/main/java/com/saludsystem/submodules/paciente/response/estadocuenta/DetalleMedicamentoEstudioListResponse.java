package com.saludsystem.submodules.paciente.response.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DetalleMedicamentoEstudioListResponse {

    @Schema(description = "Lista de estudios para el detalle de medicamentos")
    private List<DetalleMedicamentoEstudioDTO> data;

    @Schema(description = "Total de estudios para el detalle de medicamentos", example = "0")
    private long totalData;

}