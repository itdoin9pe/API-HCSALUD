package com.saludsystem.submodules.core.operaciones.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.CategoriaMatEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.MarcaEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.PresentacionEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.ProductoEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.TipoMaterialEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import com.saludsystem.submodules.operaciones.model.Producto;

public class ProductoDboMapper
{
	public static ProductoEntity toEntity(Producto model, UUID userId, UUID hospitalId)
	{
		ProductoEntity entity = new ProductoEntity();
		entity.setProductoId(model.getId());
		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setCodigoBarras(model.getCodigoBarras());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setPrecioCompra(model.getPrecioCompra());
		entity.setPrecioVenta(model.getPrecioVenta());
		entity.setStock(model.getStock());
		entity.setLote(model.getLote());
		entity.setFecha(model.getFecha());
		entity.setEstadoVenta(model.getEstadoVenta());
		entity.setEstadoCompra(model.getEstadoCompra());
		entity.setEstadoProducto(model.getEstadoProducto());
		// Relaciones de otras entidades (asumiendo que tienes setXXXEntity())
		var marca = new MarcaEntity();
		marca.setMarcaMaterialesId(model.getMarcaId());
		entity.setMarcaEntity(marca);
		// Tipo Material
		var tipo = new TipoMaterialEntity();
		tipo.setTipoMaterialId(model.getTipoMaterialId());
		entity.setTipoMaterialEntity(tipo);
		// Unidad
		var unidad = new UnidadEntity();
		unidad.setUnidadId(model.getUnidadId());
		entity.setUnidadEntity(unidad);
		// Presentacion
		var presentacion = new PresentacionEntity();
		presentacion.setPresentacionId(model.getPresentacionId());
		entity.setPresentacionEntity(presentacion);
		// Categoria material
		var categoria = new CategoriaMatEntity();
		categoria.setCategoriaMaterialId(model.getCategoriaMatId());
		entity.setCategoriaMatEntity(categoria);
		// User audit
		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);
		// Cli audit
		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);
		return entity;
	}

	public static Producto toDomain(ProductoEntity domain)
	{
		return new Producto(domain.getProductoId(), domain.getMarcaEntity().getMarcaMaterialesId(),
				domain.getTipoMaterialEntity().getTipoMaterialId(), domain.getUnidadEntity().getUnidadId(),
				domain.getPresentacionEntity().getPresentacionId(),
				domain.getCategoriaMatEntity().getCategoriaMaterialId(), domain.getCodigo(), domain.getCodigoBarras(),
				domain.getNombre(), domain.getDescripcion(), domain.getPrecioCompra(), domain.getPrecioVenta(),
				domain.getStock(), domain.getLote(), domain.getFecha(), domain.getEstadoVenta(),
				domain.getEstadoCompra(), domain.getEstadoProducto());
	}
}