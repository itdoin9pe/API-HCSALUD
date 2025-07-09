package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionDTO,
        CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO,
        UUID> {
}