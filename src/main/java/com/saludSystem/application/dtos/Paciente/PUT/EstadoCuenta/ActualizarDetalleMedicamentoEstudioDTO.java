package com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarDetalleMedicamentoEstudioDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pec_detalleMedicamentoId;

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