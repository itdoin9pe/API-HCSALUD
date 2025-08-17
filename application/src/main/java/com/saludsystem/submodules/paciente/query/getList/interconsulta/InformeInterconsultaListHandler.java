package com.saludsystem.submodules.paciente.query.getList.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InformeInterconsultaListHandler {

    private final InformeInterconsultaDao informeInterconsultaDao;
    private final InformeInterconsultaMapper informeInterconsultaMapper;

    public InformeInterconsultaListHandler(InformeInterconsultaDao informeInterconsultaDao, InformeInterconsultaMapper informeInterconsultaMapper) {
        this.informeInterconsultaDao = informeInterconsultaDao;
        this.informeInterconsultaMapper = informeInterconsultaMapper;
    }

    public List<InformeInterconsultaDTO> execute() {

        List<InformeInterconsulta> informeInterconsultaList = informeInterconsultaDao.getList();

        return informeInterconsultaList.stream()
                .map(informeInterconsultaMapper::toDto)
                .toList();

    }

}
