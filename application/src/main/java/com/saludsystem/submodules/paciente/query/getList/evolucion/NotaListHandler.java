package com.saludsystem.submodules.paciente.query.getList.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaListHandler {

    private final NotaDao notaDao;
    private final NotaMapper notaMapper;

    public NotaListHandler(NotaDao notaDao, NotaMapper notaMapper) {
        this.notaDao = notaDao;
        this.notaMapper = notaMapper;
    }

    public List<NotaDTO> execute() {

        List<Nota> notaList = notaDao.getList();

        return notaList.stream()
                .map(notaMapper::toDto)
                .toList();

    }

}
