package com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.CostoHospitalizacionBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CostoHospitalizacionResponse extends CostoHospitalizacionBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}