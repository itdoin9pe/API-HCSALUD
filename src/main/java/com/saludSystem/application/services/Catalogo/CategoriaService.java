package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarCategoriaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.CategoriaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearCategoriaDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {

    ApiResponse saveCategoria(CrearCategoriaDTO crearCategoriaDTO);

    List<CategoriaDTO> getCategoriaList();

    ApiResponse deleteCategoria(UUID categoriaId);

    ApiResponse updateCategoria(UUID categoriaId, ActualizarCategoriaDTO actualizarCategoriaDTO);

    CategoriaDTO getCategoriaById(UUID categoriaId);

    ListResponse<CategoriaDTO> getAllCategoria(UUID hospitalId, int page, int rows);

}