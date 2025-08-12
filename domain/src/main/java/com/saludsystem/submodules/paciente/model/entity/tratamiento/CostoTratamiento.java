package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CostoTratamiento {

    private UUID pacienteCostoTratamientoId;
    private UUID pacienteId;
    private UUID planTratamientoId;
    private String concepto;
    private double monto;
    private String moneda;
    private boolean pagado;

}
