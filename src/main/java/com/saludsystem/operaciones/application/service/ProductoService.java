package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.ProductoDTO;
import com.saludsystem.operaciones.application.dto.req.CrearProductoDTO;
import com.saludsystem.operaciones.application.dto.req.ActualizarProductoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    ApiResponse saveProducto(CrearProductoDTO crearProductoDTO);

    ListResponse<ProductoDTO> getAllProducto(UUID hospitalId, int page, int rows);

    List<ProductoDTO> getProductoList();

    ProductoDTO getProductoById(UUID productoId);

    ApiResponse updateProducto(UUID productoId, ActualizarProductoDTO actualizarProductoDTO);

    ApiResponse deleteProducto(UUID productoId);

}