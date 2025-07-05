package com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class DetalleMedicamentoEstudioDTO {

    private UUID pecDetalleMedicamentoId;

    private UUID pacienteId;

    private UUID pacEstadoCuentaId;

    private String tipo;

    private String descripcion;

    @Schema(example = "0")
    private Integer cantidad;

    @Schema(example = "0")
    private Double costoUnitario;

    @Schema(example = "0")
    private Double totalCosto;

}