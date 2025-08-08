package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CostoHospitalizacion {

    private UUID pec_costoHospitalizacionId;
    private UUID estadoCuentaId;
    private UUID pacienteId;
    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
    private String tipoHabitacion;
    private Double costoPorDia;
    private Integer cantidadDias;
    private Double totalCosto;

}
