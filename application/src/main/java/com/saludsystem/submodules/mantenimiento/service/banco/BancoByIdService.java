package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;

import java.util.UUID;

public class BancoByIdService {

    private final BancoDao bancoDao;

    public BancoByIdService(BancoDao bancoDao) {
        this.bancoDao = bancoDao;
    }

    public BancoDTO execute(UUID uuid) {
        return BancoMapper.toDto(bancoDao.getById(uuid));
    }
}
