package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.TarifarioConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioByIdHandler {

    private final TarifarioDao tarifarioDao;
    private final TarifarioMapper tarifarioMapper;

    public TarifarioByIdHandler(TarifarioDao tarifarioDao, TarifarioMapper tarifarioMapper) {
        this.tarifarioDao = tarifarioDao;
        this.tarifarioMapper = tarifarioMapper;
    }

    public TarifarioDTO execute(UUID uuid) {

        var tarifario = tarifarioDao.getById(uuid);

        if (tarifario == null) {

            throw new IllegalArgumentException(TarifarioConstant.INVALID_ID);

        }

        return tarifarioMapper.toDto(tarifario);

    }
}
