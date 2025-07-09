package com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetalleMedicamentoEstudioDTO extends com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO {
    private UUID hospitalId;
    private UUID userId;
}