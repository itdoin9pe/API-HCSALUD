package com.saludsystem.application.services.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionDTO,
        UUID,
        CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO> {
}