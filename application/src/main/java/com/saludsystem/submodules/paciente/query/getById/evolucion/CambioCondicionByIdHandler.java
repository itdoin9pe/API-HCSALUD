package com.saludsystem.submodules.paciente.query.getById.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.CambioCondicionConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import org.springframework.stereotype.Component;

@Component
public class CambioCondicionByIdHandler {

    private final CambioCondicionDao cambioCondicionDao;
    private final CambioCondicionMapper cambioCondicionMapper;

    public CambioCondicionByIdHandler(CambioCondicionDao cambioCondicionDao, CambioCondicionMapper cambioCondicionMapper) {
        this.cambioCondicionDao = cambioCondicionDao;
        this.cambioCondicionMapper = cambioCondicionMapper;
    }

    public CambioCondicionDTO execute(Long id) {

        var cambioCondicion = cambioCondicionDao.getById(id);

        if (cambioCondicion == null) {

            throw new IllegalArgumentException(CambioCondicionConstant.INVALID_ID);

        }

        return cambioCondicionMapper.toDto(cambioCondicion);

    }

}
