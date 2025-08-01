package com.saludsystem.submodules.paciente.dtos.get.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.dtos.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetalleMedicamentoEstudioDTO extends ActualizarDetalleMedicamentoEstudioDTO {
    private UUID hospitalId;
    private UUID userId;
}