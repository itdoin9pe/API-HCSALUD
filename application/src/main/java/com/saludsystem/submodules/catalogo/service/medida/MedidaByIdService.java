package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;

import java.util.UUID;

public class MedidaByIdService {

    private final MedidaDao medidaDao;

    public MedidaByIdService(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public MedidaDTO execute(UUID uuid) {
        return MedidaMapper.toDto(medidaDao.getById(uuid));
    }
}
