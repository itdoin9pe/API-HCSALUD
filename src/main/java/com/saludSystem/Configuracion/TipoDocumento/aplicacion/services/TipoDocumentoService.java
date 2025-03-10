package com.saludSystem.Configuracion.TipoDocumento.aplicacion.services;

import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.ActualizarTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.CrearTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.TipoDocumentoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

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