package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.ProductoDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProductoDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProductoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

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