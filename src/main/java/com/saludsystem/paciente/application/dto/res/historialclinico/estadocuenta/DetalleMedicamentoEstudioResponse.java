package com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.DetalleMedicamentoEstudioBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class DetalleMedicamentoEstudioResponse extends DetalleMedicamentoEstudioBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}