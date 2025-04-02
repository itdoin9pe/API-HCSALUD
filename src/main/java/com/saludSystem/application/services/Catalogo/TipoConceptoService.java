package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

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