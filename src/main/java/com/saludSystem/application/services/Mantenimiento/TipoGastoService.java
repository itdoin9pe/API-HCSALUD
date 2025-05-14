package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoGastoDTO;

import java.util.List;
import java.util.UUID;

public interface TipoGastoService {

    ApiResponse saveTipoGasto(CrearTipoGastoDTO crearTipoGastoDTO);

    List<TipoGastoDTO> getTipoGastoList();

    ListResponse<TipoGastoDTO> getAllTipoGasto(UUID hospitalId, int page, int rows);

    TipoGastoDTO getTipoGastoById(UUID conceptoGastoId);

    ApiResponse updateTipoGasto(UUID conceptoGastoId, ActualizarTipoGastoDTO actualizarTipoGastoDTO);

    ApiResponse deleteTipoGasto(UUID conceptoGastoId);

}