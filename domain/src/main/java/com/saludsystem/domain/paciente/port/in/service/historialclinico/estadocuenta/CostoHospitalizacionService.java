package com.saludsystem.domain.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionDTO,
        CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO,
        UUID> {
}