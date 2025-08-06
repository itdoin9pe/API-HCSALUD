package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DetalleMedicamentoEstudioDTO {

    private UUID detalleMedicamentoEstudioId;

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