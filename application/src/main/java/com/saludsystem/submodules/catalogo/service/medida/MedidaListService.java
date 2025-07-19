package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;

import java.util.List;

public class MedidaListService {

    private final MedidaDao medidaDao;

    public MedidaListService(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public List<MedidaDTO> execute() {
        return medidaDao.getList().stream().map(MedidaMapper::toDto).toList();
    }
}
