package com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.EstadoCuentaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class EstadoCuentaResponse extends EstadoCuentaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}