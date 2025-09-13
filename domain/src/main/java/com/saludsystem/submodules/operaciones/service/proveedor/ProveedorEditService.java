package com.saludsystem.submodules.operaciones.service.proveedor;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import com.saludsystem.submodules.operaciones.port.repository.ProveedorRepository;

public class ProveedorEditService
{
	private final ProveedorDao proveedorDao;
	private final ProveedorRepository proveedorRepository;

	public ProveedorEditService(ProveedorDao proveedorDao, ProveedorRepository proveedorRepository)
	{
		this.proveedorDao = proveedorDao;
		this.proveedorRepository = proveedorRepository;
	}

	public Proveedor execute(UUID uuid, Proveedor proveedor)
	{
		var currentProveedor = proveedorDao.getById(uuid);
		if (currentProveedor.getRuc() != null && currentProveedor.getRuc() == "INACTIVE")
		{
			throw new IllegalStateException("El proveedor ya se encuentra sin RUC");
		}
		return proveedorRepository.update(uuid, proveedor);
	}
}
