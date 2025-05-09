package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarExploracionFisicaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface ExploracionFisicaService {

    ApiResponse saveExploracionFisica(CrearExploracionFisicaDTO crearExploracionFisicaDTO);

    ExploracionFisicaDTO getExploracionFisicaById(UUID pacienteExploracionId);

    ApiResponse updateExploracionFisica(UUID pacienteExploracionId, ActualizarExploracionFisicaDTO actualizarExploracionFisicaDTO);

    ListResponse<ExploracionFisicaDTO> getAllExploracionFisica(UUID hospitalId, int page, int rows);

    ApiResponse deleteExploracionFisica(UUID pacienteExploracionId);

}