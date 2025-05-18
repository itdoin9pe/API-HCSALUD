package com.saludSystem.application.services.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearCostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarCostoHospitalizacionDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface CostoHospitalizacionService {

    ApiResponse saveCostoHospitalizacion(CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO);

    ListResponse<CostoHospitalizacionDTO> getAllCostoHospitalizacion(UUID hospitalId, int page, int rows);

    ApiResponse updateCostoHospitalizacion(UUID pec_costoHospitalizacionId, ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO);

    CostoHospitalizacionDTO getCostoHospitalizacionById(UUID pec_costoHospitalizacionId);

    ApiResponse deleteCostoHospitalizacion(UUID pec_costoHospitalizacionId);

}