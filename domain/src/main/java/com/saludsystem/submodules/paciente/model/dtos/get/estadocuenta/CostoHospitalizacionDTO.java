package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CostoHospitalizacionDTO {

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

    public CostoHospitalizacionDTO(UUID pecCostoHospitalizacionId, UUID estadoCuentaId, UUID pacienteId,
                                   LocalDate fechaIngreso, LocalDate fechaAlta, String tipoHabitacion,
                                   Double costoPorDia, Integer cantidadDias, Double totalCosto) {
        this.setPecCostoHospitalizacionId(pecCostoHospitalizacionId);
        this.setPacEstadoCuentaId(estadoCuentaId);
        this.setPacienteId(pacienteId);
        this.setFechaIngreso(fechaIngreso);
        this.setFechaAlta(fechaAlta);
        this.setTipoHabitacion(tipoHabitacion);
        this.setCostoPorDia(costoPorDia);
        this.setCantidadDias(cantidadDias);
        this.setTotalCosto(totalCosto);
    }

}