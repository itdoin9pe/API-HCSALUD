package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarBancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.BancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearBancoDTO;

import java.util.List;
import java.util.UUID;

public interface BancoService {

    ApiResponse saveBanco(CrearBancoDTO crearBancoDTO);

    List<BancoDTO> getBancoList();

    BancoDTO getBancoById(UUID bancoId);

    ListResponse<BancoDTO> getAllBanco(UUID hospitalId, int page, int rows);

    ApiResponse updateBanco(UUID bancoId, ActualizarBancoDTO actualizarBancoDTO);

    ApiResponse deleteBanco(UUID bancoId);

}