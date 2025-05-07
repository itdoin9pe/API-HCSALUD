package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarExploracionFisicaDTO;
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