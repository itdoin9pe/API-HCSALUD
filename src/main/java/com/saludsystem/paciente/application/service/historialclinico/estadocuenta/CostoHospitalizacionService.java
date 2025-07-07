package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CrearCostoHospitalizacionDTO,
        CostoHospitalizacionDTO,
        UUID> {
}