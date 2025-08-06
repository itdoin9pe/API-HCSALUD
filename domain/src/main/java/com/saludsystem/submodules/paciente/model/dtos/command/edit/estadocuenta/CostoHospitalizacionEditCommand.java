package com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostoHospitalizacionEditCommand extends BaseDTO {

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