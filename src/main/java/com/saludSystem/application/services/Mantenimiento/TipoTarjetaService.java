package com.saludSystem.application.services.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;

import java.util.List;
import java.util.UUID;

public interface TipoTarjetaService {

    ApiResponse saveTipoTarjeta(CrearTipoTarjetaDTO crearTipoTarjetaDTO);

    List<TipoTarjetaDTO> getTipoTarjetaList();

    ListResponse<TipoTarjetaDTO> getAllTipoTarjeta(UUID hospitalId, int page, int rows);

    TipoTarjetaDTO getTipoTarjetaById(UUID tipoTarjetaId);

    ApiResponse updateTipoTarjeta(UUID tipoTarjetaId, ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO);

    ApiResponse deleteTipoTarjeta(UUID tipoTarjetaId);

}