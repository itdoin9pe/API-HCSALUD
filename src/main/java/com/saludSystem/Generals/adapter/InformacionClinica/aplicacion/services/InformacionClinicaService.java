package com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.services;

import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.ActualizarInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.CrearInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.InformacionClinicaDTO;
import com.saludSystem.Generals.response.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface InformacionClinicaService {

    List<InformacionClinicaDTO> getInformacionClinicaList();

    ApiResponse saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO);

    InformacionClinicaDTO getInformacionClinicaById(UUID informacionClinicaId);

    ApiResponse deleteInformacionClinica(UUID informacionClinicaId);

    ApiResponse updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO);

}