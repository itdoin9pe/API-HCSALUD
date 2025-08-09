package com.saludsystem.submodules.paciente.query.getList.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CambioCondicionListHandler {

    private final CambioCondicionDao cambioCondicionDao;
    private final CambioCondicionMapper cambioCondicionMapper;

    public CambioCondicionListHandler(CambioCondicionDao cambioCondicionDao, CambioCondicionMapper cambioCondicionMapper) {
        this.cambioCondicionDao = cambioCondicionDao;
        this.cambioCondicionMapper = cambioCondicionMapper;
    }

    public List<CambioCondicionDTO> execute() {

        List<CambioCondicion> cambioCondicionList = cambioCondicionDao.getList();

        return cambioCondicionList.stream()
                .map(cambioCondicionMapper::toDto)
                .toList();

    }

}
