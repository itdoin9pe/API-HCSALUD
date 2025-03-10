package com.saludSystem.Catalogo.Categoria.aplicacion.services;

import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.ActualizarCategoriaDTO;
import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CategoriaDTO;
import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CrearCategoriaDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

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