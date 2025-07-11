package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.operaciones.application.dto.get.ProductoDTO;
import com.saludsystem.operaciones.application.dto.post.CrearProductoDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarProductoDTO;
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