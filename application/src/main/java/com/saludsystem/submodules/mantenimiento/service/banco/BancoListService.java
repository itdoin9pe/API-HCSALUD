package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;

import java.util.List;

public class BancoListService {

    private final BancoDao bancoDao;

    public BancoListService(BancoDao bancoDao) {
        this.bancoDao = bancoDao;
    }

    public List<BancoDTO> execute() {
        return bancoDao.getList().stream().map(BancoMapper::toDto).toList();
    }
}
