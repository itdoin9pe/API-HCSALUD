package com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostoHospitalizacionDTO extends CrearCostoHospitalizacionDTO {

    private UUID pecCostoHospitalizacionId;

}