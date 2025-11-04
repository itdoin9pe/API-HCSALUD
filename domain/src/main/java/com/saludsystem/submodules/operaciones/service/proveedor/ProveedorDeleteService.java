package com.saludsystem.submodules.operaciones.service.proveedor;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import com.saludsystem.submodules.operaciones.port.repository.ProveedorRepository;

public class ProveedorDeleteService
{
	private final ProveedorRepository proveedorRepository;
	private final ProveedorDao proveedorDao;

	public ProveedorDeleteService(ProveedorRepository proveedorRepository, ProveedorDao proveedorDao)
	{
		this.proveedorRepository = proveedorRepository;
		this.proveedorDao = proveedorDao;
	}

	public void execute(UUID uuid)
	{
		var proveedor = proveedorDao.getById(uuid);
		if (proveedor.getRuc() != null && proveedor.getRuc() == "INACTIVE")
		{
			throw new IllegalStateException("No se puede eliminar un proveedor con RUC desactivado");
		}
		proveedorRepository.delete(uuid);
	}
}
