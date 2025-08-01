package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;

import java.util.UUID;

public class BancoEditService {

    private final BancoDao bancoDao;
    private final BancoRepository bancoRepository;

    public BancoEditService(BancoDao bancoDao, BancoRepository bancoRepository) {
        this.bancoDao = bancoDao;
        this.bancoRepository = bancoRepository;
    }

    public Banco execute(UUID uuid, Banco banco) {

        var currentBanco = bancoDao.getById(uuid);

        if (currentBanco.getEstado() != null && currentBanco.getEstado() == 0) {

            throw new IllegalStateException("El tipo de banco ya se encuentra desactivada");

        }

        return bancoRepository.update(uuid, banco);

    }

}
