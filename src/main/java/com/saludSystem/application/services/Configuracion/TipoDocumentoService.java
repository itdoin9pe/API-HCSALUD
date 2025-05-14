package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.TipoDocumentoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoDocumentoService {

    ApiResponse saveTipoDocumento(CrearTipoDocumentoDTO crearTipoDocumentoDTO);

    ListResponse<TipoDocumentoDTO> getAllTipoDocumento(UUID hospitalId, int page, int rows);

    TipoDocumentoDTO getTipoDocumentoById(UUID tDocumentoId);

    List<TipoDocumentoDTO> getTipoDocumentoList();

    ApiResponse updateTipoDocumento(UUID tDocumentoId, ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO);

    ApiResponse deleteTipoDocumento(UUID tDocumentoId);

}