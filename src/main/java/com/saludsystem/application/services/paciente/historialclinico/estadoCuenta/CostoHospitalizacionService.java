package com.saludsystem.application.services.paciente.historialclinico.estadoCuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionDTO,
        UUID,
        CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO> {
}