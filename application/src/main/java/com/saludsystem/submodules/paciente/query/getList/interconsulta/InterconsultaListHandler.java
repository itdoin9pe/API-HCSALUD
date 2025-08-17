package com.saludsystem.submodules.paciente.query.getList.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InterconsultaListHandler {

    private final InterconsultaDao interconsultaDao;
    private final InterconsultaMapper interconsultaMapper;

    public InterconsultaListHandler(InterconsultaDao interconsultaDao, InterconsultaMapper interconsultaMapper) {
        this.interconsultaDao = interconsultaDao;
        this.interconsultaMapper = interconsultaMapper;
    }

    public List<InterconsultaDTO> execute() {

        List<Interconsulta> interconsultaList = interconsultaDao.getList();

        return interconsultaList.stream()
                .map(interconsultaMapper::toDto)
                .toList();

    }

}
