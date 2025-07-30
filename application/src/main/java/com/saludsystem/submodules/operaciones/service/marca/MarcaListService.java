package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;

import java.util.List;

public class MarcaListService {

    private final MarcaDao marcaDao;

    public MarcaListService(MarcaDao marcaDao) {
        this.marcaDao = marcaDao;
    }

    public List<MarcaDTO> execute() {
        return marcaDao.getList()
                .stream()
                .map(MarcaMapper::toDto)
                .toList();
    }

}
