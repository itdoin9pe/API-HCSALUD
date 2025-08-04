package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorListHandler {

    private final ProveedorDao proveedorDao;
    private final ProveedorMapper proveedorMapper;

    public ProveedorListHandler(ProveedorDao proveedorDao, ProveedorMapper proveedorMapper) {
        this.proveedorDao = proveedorDao;
        this.proveedorMapper = proveedorMapper;
    }

    public List<ProveedorDTO> execute() {

        List<Proveedor> proveedorList = proveedorDao.getList();

        return proveedorList.stream()
                .map(proveedorMapper::toDto)
                .toList();

    }

}
