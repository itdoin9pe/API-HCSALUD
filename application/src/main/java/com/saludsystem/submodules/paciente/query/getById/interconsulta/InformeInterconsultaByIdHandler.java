package com.saludsystem.submodules.paciente.query.getById.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InformeInterconsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformeInterconsultaByIdHandler {

    private final InformeInterconsultaDao informeInterconsultaDao;
    private final InformeInterconsultaMapper informeInterconsultaMapper;

    public InformeInterconsultaByIdHandler(InformeInterconsultaDao informeInterconsultaDao, InformeInterconsultaMapper informeInterconsultaMapper) {
        this.informeInterconsultaDao = informeInterconsultaDao;
        this.informeInterconsultaMapper = informeInterconsultaMapper;
    }

    public InformeInterconsultaDTO execute(UUID uuid) {

        var informeInter = informeInterconsultaDao.getById(uuid);

        if (informeInter == null) {

            throw new IllegalArgumentException(InformeInterconsultaConstant.INVALID_ID);

        }

        return informeInterconsultaMapper.toDto(informeInter);

    }

}
