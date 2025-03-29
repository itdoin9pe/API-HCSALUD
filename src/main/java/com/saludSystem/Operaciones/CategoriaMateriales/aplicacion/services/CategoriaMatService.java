package com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.ActualizarCategoriaMatDTO;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.CategoriaMatDTO;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.CrearCategotiaMatDTO;

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