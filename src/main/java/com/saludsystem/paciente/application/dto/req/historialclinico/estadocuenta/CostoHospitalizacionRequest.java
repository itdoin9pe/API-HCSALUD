package com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.CostoHospitalizacionBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CostoHospitalizacionRequest extends CostoHospitalizacionBaseDTO {

    private UUID pecCostoHospitalizacionId;

}