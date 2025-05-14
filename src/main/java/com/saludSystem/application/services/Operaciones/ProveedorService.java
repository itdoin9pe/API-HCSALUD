package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProveedorDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProveedorService {

    ApiResponse saveProveedor(CrearProveedorDTO crearProveedorDTO);

    List<ProveedorDTO> getProveedorList();

    ProveedorDTO getProveedorById(UUID proveedorId);

    ListResponse<ProveedorDTO> getAllProveedor(UUID hospitalId, int page, int rows);

    ApiResponse updateProveedor(UUID proveedorId, ActualizarProveedorDTO actualizarProveedorDTO);

    ApiResponse deleteProveedor(UUID proveedorId);

}