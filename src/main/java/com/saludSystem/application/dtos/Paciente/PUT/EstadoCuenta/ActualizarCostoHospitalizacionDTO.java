package com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarCostoHospitalizacionDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pec_costoHospitalizacionId;

    private UUID pec_estadoCuentaId;

    private LocalDate fechaIngreso;

    private LocalDate fechaAlta;

    private String tipoHabitacion;

    @Schema(example = "0")
    private Double costoPorDia;

    @Schema(example = "Integer")
    private Integer cantidadDias;

    @Schema(example = "0")
    private Double totalCosto;

}