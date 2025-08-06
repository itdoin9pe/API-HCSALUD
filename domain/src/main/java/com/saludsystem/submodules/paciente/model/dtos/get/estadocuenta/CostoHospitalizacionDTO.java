package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.command.estadocuenta.CrearCostoHospitalizacionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostoHospitalizacionDTO extends CrearCostoHospitalizacionDTO {

    private UUID pecCostoHospitalizacionId;

}