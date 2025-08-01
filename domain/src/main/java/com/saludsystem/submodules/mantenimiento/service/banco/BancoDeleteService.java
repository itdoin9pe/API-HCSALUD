package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;

import java.util.UUID;

public class BancoDeleteService {

    private final BancoRepository bancoRepository;
    private final BancoDao bancoDao;

    public BancoDeleteService(BancoRepository bancoRepository, BancoDao bancoDao) {
        this.bancoRepository = bancoRepository;
        this.bancoDao = bancoDao;
    }

    public void execute(UUID uuid) {

        var banco = bancoDao.getById(uuid);

        if (banco.getEstado() != null && banco.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un tipo debanco ya desactivado");

        }

        bancoRepository.delete(uuid);

    }

}
