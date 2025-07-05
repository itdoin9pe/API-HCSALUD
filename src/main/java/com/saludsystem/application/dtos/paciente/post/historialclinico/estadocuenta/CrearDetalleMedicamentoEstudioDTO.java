package com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class CrearDetalleMedicamentoEstudioDTO {

    private UUID pacienteId;

    private UUID estadoCuentaId;

    private String tipo;

    private String descripcion;

    @Schema(example = "0")
    private Integer cantidad;

    @Schema(example = "0")
    private Double costoUnitario;

    @Schema(example = "0")
    private Double totalCosto;

}