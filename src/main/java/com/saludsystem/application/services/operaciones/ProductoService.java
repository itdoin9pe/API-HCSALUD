package com.saludsystem.application.services.operaciones;

import com.saludsystem.application.dtos.operaciones.get.ProductoDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearProductoDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarProductoDTO;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;

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