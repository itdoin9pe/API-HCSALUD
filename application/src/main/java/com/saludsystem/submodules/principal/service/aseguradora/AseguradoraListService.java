package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;

import java.util.List;

public class AseguradoraListService {

    private final AseguradoraDao aseguradoraDao;

    public AseguradoraListService(AseguradoraDao aseguradoraDao) {
        this.aseguradoraDao = aseguradoraDao;
    }

    public List<AseguradoraDTO> execute() {
        return aseguradoraDao.getList()
                .stream()
                .map(AseguradoraMapper::toDto)
                .toList();
    }

}
