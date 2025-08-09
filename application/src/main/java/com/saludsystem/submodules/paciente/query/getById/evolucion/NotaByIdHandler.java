package com.saludsystem.submodules.paciente.query.getById.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.NotaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import org.springframework.stereotype.Component;

@Component
public class NotaByIdHandler {

    private final NotaDao notaDao;
    private final NotaMapper notaMapper;

    public NotaByIdHandler(NotaDao notaDao, NotaMapper notaMapper) {
        this.notaDao = notaDao;
        this.notaMapper = notaMapper;
    }

    public NotaDTO execute(Long id) {

        var nota = notaDao.getById(id);

        if (nota == null) {

            throw new IllegalArgumentException(NotaConstant.INVALID_ID);

        }

        return notaMapper.toDto(nota);

    }

}
