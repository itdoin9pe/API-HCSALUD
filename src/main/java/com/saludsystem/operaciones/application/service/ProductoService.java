package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.ProductoResponse;
import com.saludsystem.operaciones.application.dto.req.ProductoRequest;
import com.saludsystem.operaciones.application.dto.req.ActualizarProductoDTO;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    ApiResponse saveProducto(ProductoRequest productoRequest);

    ListResponse<ProductoResponse> getAllProducto(UUID hospitalId, int page, int rows);

    List<ProductoResponse> getProductoList();

    ProductoResponse getProductoById(UUID productoId);

    ApiResponse updateProducto(UUID productoId, ActualizarProductoDTO actualizarProductoDTO);

    ApiResponse deleteProducto(UUID productoId);

}