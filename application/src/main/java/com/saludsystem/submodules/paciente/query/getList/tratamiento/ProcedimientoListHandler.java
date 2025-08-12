package com.saludsystem.submodules.paciente.query.getList.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcedimientoListHandler {

    private final ProcedimientoDao procedimientoDao;
    private final ProcedimientoMapper procedimientoMapper;

    public ProcedimientoListHandler(ProcedimientoDao procedimientoDao, ProcedimientoMapper procedimientoMapper) {
        this.procedimientoDao = procedimientoDao;
        this.procedimientoMapper = procedimientoMapper;
    }

    public List<ProcedimientoDTO> execute() {

        List<Procedimiento> procedimientoList = procedimientoDao.getList();

        return procedimientoList.stream()
                .map(procedimientoMapper::toDto)
                .toList();

    }

}
