package com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.PagoBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PagoRequest extends PagoBaseDTO {
    private UUID pecPagoId;
}