package com.saludsystem.submodules.operaciones.service.producto;

import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.model.constant.ProductoConstant;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;
import com.saludsystem.submodules.operaciones.port.repository.ProductoRepository;

import java.util.UUID;

public class ProductoEditService {

    private final ProductoDao productoDao;
    private final ProductoRepository productoRepository;

    public ProductoEditService(ProductoDao productoDao, ProductoRepository productoRepository) {
        this.productoDao = productoDao;
        this.productoRepository = productoRepository;
    }

    public Producto execute(UUID uuid, Producto producto) {

        var currentProd = productoDao.getById(uuid);

        if (currentProd == null) {
            throw new IllegalArgumentException(ProductoConstant.ID_NOT_FOUND);
        }

        if (currentProd.getEstadoProducto() != null && currentProd.getEstadoProducto() == 0) {
            throw new IllegalStateException("El producto ya se encuentra desactivado");
        }

        return productoRepository.update(uuid, producto);

    }

}
