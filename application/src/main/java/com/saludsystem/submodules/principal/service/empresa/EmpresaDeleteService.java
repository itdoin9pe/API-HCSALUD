package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

import java.util.UUID;

public class EmpresaDeleteService {

    private final EmpresaRepository empresaRepository;

    public EmpresaDeleteService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void execute(UUID uuid) {
        empresaRepository.delete(uuid);
    }
}
