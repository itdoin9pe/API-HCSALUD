package com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento;

import com.saludsystem.submodules.paciente.model.constant.tratamiento.ProcedimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.ProcedimientoRepository;

import java.util.UUID;

public class ProcedimientoEditService {

    private final ProcedimientoDao procedimientoDao;
    private final ProcedimientoRepository procedimientoRepository;

    public ProcedimientoEditService(ProcedimientoDao procedimientoDao, ProcedimientoRepository procedimientoRepository) {
        this.procedimientoDao = procedimientoDao;
        this.procedimientoRepository = procedimientoRepository;
    }

    public Procedimiento execute(UUID uuid, Procedimiento procedimiento) {

        var currentProcedimiento = procedimientoDao.getById(uuid);

        if (currentProcedimiento == null) {

            throw new IllegalArgumentException(ProcedimientoConstant.INVALID_ID);

        }

        if (currentProcedimiento.getDescripcion() != null && currentProcedimiento.getDescripcion().equals(" ")) {

            throw new IllegalStateException("No se pude modificar un procedimiento vacio");

        }

        return procedimientoRepository.update(uuid, procedimiento);

    }

}
