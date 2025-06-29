package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearCostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarCostoHospitalizacionDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface CostoHospitalizacionService extends GenericService<
        CostoHospitalizacionDTO,
        UUID,
        CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO> {
}