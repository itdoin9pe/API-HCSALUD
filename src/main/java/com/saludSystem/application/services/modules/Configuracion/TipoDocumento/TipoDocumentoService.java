package com.saludSystem.application.services.modules.Configuracion.TipoDocumento;

import com.saludSystem.application.dtos.Configuracion.TipoDocumento.ActualizarTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.TipoDocumento.CrearTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.TipoDocumento.TipoDocumentoDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;

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