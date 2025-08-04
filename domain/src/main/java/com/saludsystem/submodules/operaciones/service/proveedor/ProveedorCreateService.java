package com.saludsystem.submodules.operaciones.service.proveedor;

import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.port.repository.ProveedorRepository;

public class ProveedorCreateService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorCreateService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public Proveedor execute(Proveedor proveedor) {

        return proveedorRepository.save(proveedor);

    }

}
