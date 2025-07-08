package com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.EstadoCuentaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class EstadoCuentaRequest extends EstadoCuentaBaseDTO {
    private UUID pacEstadoCuentaId;
}