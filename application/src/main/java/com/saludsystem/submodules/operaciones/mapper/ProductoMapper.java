package com.saludsystem.submodules.operaciones.mapper;

import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProductoCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProductoEditCommand;

import java.util.UUID;

public class ProductoMapper {

	public Producto fromCreateDto(ProductoCreateCommand createCommand) {
		return new Producto(null, createCommand.getMarcaMaterialesId(), createCommand.getTipoMaterialId(),
				createCommand.getUnidadId(), createCommand.getPresentacionId(), createCommand.getCategoriaMaterialId(),
				createCommand.getCodigo(), createCommand.getCodigoBarras(), createCommand.getNombre(),
				createCommand.getDescripcion(), createCommand.getPrecioCompra(), createCommand.getPrecioVenta(),
				createCommand.getStock(), createCommand.getLote(), createCommand.getFecha(),
				createCommand.getEstadoVenta(), createCommand.getEstadoCompra(), createCommand.getEstadoProducto());
	}

	public Producto fromUpdateDto(UUID uuid, ProductoEditCommand editCommand) {
		return new Producto(uuid, editCommand.getMarcaMaterialesId(), editCommand.getTipoMaterialId(),
				editCommand.getUnidadId(), editCommand.getPresentacionId(), editCommand.getCategoriaMaterialId(),
				editCommand.getCodigo(), editCommand.getCodigoBarras(), editCommand.getNombre(), 
				editCommand.getDescripcion(),editCommand.getPrecioCompra(), 
				editCommand.getPrecioVenta(), editCommand.getStock(),
				editCommand.getLote(), editCommand.getFecha(), editCommand.getEstadoVenta(),
				editCommand.getEstadoCompra(), editCommand.getEstadoProducto());
	}

	public ProductoDTO toDto(Producto model) {
		return new ProductoDTO(model.getId(), model.getMarcaId(), model.getTipoMaterialId(), model.getUnidadId(),
				model.getPresentacionId(), model.getCategoriaMatId(), model.getCodigo(), model.getCodigoBarras(),
				model.getNombre(), model.getDescripcion(), model.getLote(), model.getFecha(), model.getStock(),
				model.getPrecioCompra(), model.getPrecioVenta(), model.getEstadoProducto(), model.getEstadoVenta(),
				model.getEstadoCompra());
	}
}