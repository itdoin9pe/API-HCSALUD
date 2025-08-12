package com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento;

import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.ProcedimientoRepository;

import java.util.UUID;

public class ProcedimientoDeleteService {

    private final ProcedimientoRepository procedimientoRepository;
    private final ProcedimientoDao procedimientoDao;

    public ProcedimientoDeleteService(ProcedimientoRepository procedimientoRepository, ProcedimientoDao procedimientoDao) {
        this.procedimientoRepository = procedimientoRepository;
        this.procedimientoDao = procedimientoDao;
    }

    public void execute(UUID uuid) {

        var procedimiento = procedimientoDao.getById(uuid);

        if (procedimiento.getResultado() != null && procedimiento.getResultado().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar un procedimiento sin resultado previo");

        }

        procedimientoRepository.delete(uuid);

    }

}
