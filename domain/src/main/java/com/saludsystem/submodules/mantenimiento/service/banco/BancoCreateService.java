package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;

public class BancoCreateService {

    private final BancoRepository bancoRepository;

    public BancoCreateService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public Banco execute(Banco banco) {

        return bancoRepository.save(banco);

    }
}
