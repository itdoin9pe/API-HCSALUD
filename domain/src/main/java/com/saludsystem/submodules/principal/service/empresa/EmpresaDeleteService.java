package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

import java.util.UUID;

public class EmpresaDeleteService {

    private final EmpresaRepository empresaRepository;
    private final EmpresaDao empresaDao;

    public EmpresaDeleteService(EmpresaRepository empresaRepository, EmpresaDao empresaDao) {
        this.empresaRepository = empresaRepository;
        this.empresaDao = empresaDao;
    }

    public void execute(UUID uuid) {

        var empresa = empresaDao.getById(uuid);

        if (empresa.getEstado() != null && empresa.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar una empresa ya desactivada");

        }

        empresaRepository.delete(uuid);

    }

}
