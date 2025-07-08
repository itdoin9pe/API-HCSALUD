package com.saludsystem.paciente.application.service.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.CostoHospitalizacionResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.CostoHospitalizacionRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionRequest,
        CostoHospitalizacionResponse,
        UUID> {
}