package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class DetalleMedicamentoEstudio {

    private UUID pec_detalleMedicamentoId;
    private UUID pacienteEntity;
    private UUID estadoCuentaEntity;
    private String tipo;
    private String descripcion;
    private Integer cantidad;
    private Double costoUnitario;
    private Double totalCosto;

}
