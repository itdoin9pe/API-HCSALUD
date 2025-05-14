package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AlmacenService {

    ApiResponse saveAlmacen(CrearAlmacenDTO crearAlmacenDTO);

    List<AlmacenDTO> getAlmacenList();

    AlmacenDTO getAlmacenById(UUID almacenId);

    ListResponse<AlmacenDTO> getAllAlmacen(UUID hospitalId, int page, int rows);

    ApiResponse updateAlmacen(UUID almacenId, ActualizarAlmacenDTO actualizarAlmacenDTO);

    ApiResponse deleteAlmacen(UUID almacenId);

}