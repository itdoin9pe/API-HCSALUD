package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaByIdHandler {
    private final MedidaDao medidaDao;

    public MedidaByIdHandler(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public MedidaDTO execute(UUID uuid) {
        Medida model = medidaDao.getById(uuid);
        return MedidaMapper.toDto(model);
    }
}
