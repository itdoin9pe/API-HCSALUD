package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.VentaDetalleEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;

import java.util.UUID;

public class VentaDetalleDboMapper {

    public static VentaDetalleEntity toEntity(VentaDetalle model, UUID hospitalId, UUID userId) {
        VentaDetalleEntity entity = new VentaDetalleEntity();
        // Producto
        ProductoEntity producto = new ProductoEntity();
        producto.setProductoId(model.getProductoId());
        entity.setProductoEntity(producto);
        entity.setCodigoProducto(model.getCodigoProducto());
        entity.setCantidad(model.getCantidad());
        entity.setPrecio(model.getPrecioUnitario());
        entity.setSubtotal(model.getSubtotal());
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);
        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);
        return entity;
    }

    public static VentaDetalle toDomain(VentaDetalleEntity entity) {
        return new VentaDetalle(
                entity.getVentaDetalleId(),
                entity.getVentaEntity().getVentaId(),
                entity.getProductoEntity().getProductoId(),
                entity.getCodigoProducto(),
                entity.getCantidad(),
                entity.getPrecio(),
                entity.getSubtotal());
    }
}