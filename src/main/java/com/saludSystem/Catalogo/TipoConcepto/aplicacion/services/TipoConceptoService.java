package com.saludSystem.Catalogo.TipoConcepto.aplicacion.services;

import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.ActualizarTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.CrearTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.TipoConceptoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoConceptoService {

    ApiResponse saveTipoConcepto(CrearTipoConceptoDTO crearTipoConceptoDTO);

    ApiResponse updateTipoConcepto(UUID tipoConveptoId, ActualizarTipoConceptoDTO actualizarTipoConceptoDTO);

    TipoConceptoDTO getTipoConceptoById(UUID tipoConceptoId);

    List<TipoConceptoDTO> getTipoConceptoList();

    ApiResponse deleteTipoConcepto(UUID tipoConceptoId);

    ListResponse<TipoConceptoDTO> getAllTipoConcepto(UUID hospitalId, int page, int rows);

}