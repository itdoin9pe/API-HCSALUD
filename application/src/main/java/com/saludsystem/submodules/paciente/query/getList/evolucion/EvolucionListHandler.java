package com.saludsystem.submodules.paciente.query.getList.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EvolucionListHandler {

    private final EvolucionDao evolucionDao;
    private final EvolucionMapper evolucionMapper;

    public EvolucionListHandler(EvolucionDao evolucionDao, EvolucionMapper evolucionMapper) {
        this.evolucionDao = evolucionDao;
        this.evolucionMapper = evolucionMapper;
    }

    public List<EvolucionDTO> execute() {

        List<Evolucion> evolucionList = evolucionDao.getList();

        return evolucionList.stream()
                .map(evolucionMapper::toDto)
                .toList();

    }

}
