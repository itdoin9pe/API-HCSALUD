package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.model.constant.RolConstant;
import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RolByIdHandler {

    private final RolDao rolDao;
    private final RolMapper rolMapper;

    public RolByIdHandler(RolDao rolDao, RolMapper rolMapper) {
        this.rolDao = rolDao;
        this.rolMapper = rolMapper;
    }

    public RolDTO execute(UUID uuid) {

        var rol = rolDao.getById(uuid);

        if (rol == null) {

            throw new IllegalArgumentException(RolConstant.ID_NOT_FOUND);

        }

        return rolMapper.toDto(rol);

    }

}
