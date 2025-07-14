package com.saludsystem.application.paciente.dtos.put.historialclinico.estadocuenta;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCostoHospitalizacionDTO extends BaseDTO {

    private UUID pecCostoHospitalizacionId;

    private UUID pacEstadoCuentaId;

    private UUID pacienteId;

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