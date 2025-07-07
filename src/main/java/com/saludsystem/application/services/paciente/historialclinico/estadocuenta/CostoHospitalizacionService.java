package com.saludsystem.application.services.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CrearCostoHospitalizacionDTO,
        CostoHospitalizacionDTO,
        UUID> {
}