package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoMaterialService {

    ApiResponse saveTipoMaterial(CrearTipoMaterialDTO crearTipoMaterialDTO);

    List<TipoMaterialDTO> getTipoMaterialList();

    TipoMaterialDTO getTipoMaterialById(UUID tipoMaterialId);

    ListResponse<TipoMaterialDTO> getAllTipoMaterial(UUID hospitalId, int page, int rows);

    ApiResponse updateTipoMaterial(UUID tipoMaterialId, ActualizarTipoMaterialDTO actualizarTipoMaterialDTO);

    ApiResponse deleteTipoMaterial(UUID tipoMaterialId);

}