package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;

import java.util.UUID;

public class BancoDeleteService {

    private final BancoRepository bancoRepository;

    public BancoDeleteService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public void execute(UUID uuid) {
        bancoRepository.delete(uuid);
    }

}
