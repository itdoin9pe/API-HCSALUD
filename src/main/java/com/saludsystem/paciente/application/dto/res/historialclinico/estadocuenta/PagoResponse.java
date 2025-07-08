package com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta;

import lombok.Data;

import java.util.UUID;

@Data
public class PagoResponse {
    private UUID hospitalId;
    private UUID userId;
}