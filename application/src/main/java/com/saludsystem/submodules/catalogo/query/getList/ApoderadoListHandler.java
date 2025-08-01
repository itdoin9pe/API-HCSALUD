package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApoderadoListHandler {

    private final ApoderadoDao apoderadoDao;
    private final ApoderadoMapper apoderadoMapper;

    public ApoderadoListHandler(ApoderadoDao apoderadoDao, ApoderadoMapper apoderadoMapper) {
        this.apoderadoDao = apoderadoDao;
        this.apoderadoMapper = apoderadoMapper;
    }

    public List<ApoderadoDTO> execute() {

        List<Apoderado> apoderadoList = apoderadoDao.getList();

        return apoderadoList.stream()
                .map(apoderadoMapper::toDto)
                .toList();

    }

}
