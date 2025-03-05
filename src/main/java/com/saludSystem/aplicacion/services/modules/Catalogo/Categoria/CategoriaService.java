package com.saludSystem.aplicacion.services.modules.Catalogo.Categoria;

import com.saludSystem.aplicacion.dtos.Catalogo.Categoria.ActualizarCategoriaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Categoria.CategoriaDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Categoria.CrearCategoriaDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;

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