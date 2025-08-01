package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BancoListHandler {

    private final BancoDao bancoDao;
    private final BancoMapper bancoMapper;

    public BancoListHandler(BancoDao bancoDao, BancoMapper bancoMapper) {
        this.bancoDao = bancoDao;
        this.bancoMapper = bancoMapper;
    }

    public List<BancoDTO> execute() {

        List<Banco> bancoList = bancoDao.getList();

        return bancoList.stream()
                .map(bancoMapper::toDto)
                .toList();

    }

}
