package com.saludSystem.application.services.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaMatService {

    ApiResponse saveCategoriaMaterial(CrearCategotiaMatDTO crearCategotiaMatDTO);

    List<CategoriaMatDTO> getCategoriaMaterialList();

    ListResponse<CategoriaMatDTO> getAllCategoriaMaterial(UUID hospitalId, int page, int rows);

    CategoriaMatDTO getCategoriaMaterialById(UUID categoriaMaterialId);

    ApiResponse updateCategoriaMaterial(UUID categoriaMaterialId, ActualizarCategoriaMatDTO actualizarCategoriaMatDTO);

    ApiResponse deleteCategoriaMaterial(UUID categoriaMaterialId);

}