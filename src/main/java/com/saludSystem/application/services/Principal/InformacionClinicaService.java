package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.GET.InformacionClinicaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface InformacionClinicaService {

    List<InformacionClinicaDTO> getInformacionClinicaList();

    ApiResponse saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO);

    InformacionClinicaDTO getInformacionClinicaById(UUID informacionClinicaId);

    ApiResponse deleteInformacionClinica(UUID informacionClinicaId);

    ApiResponse updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO);

}