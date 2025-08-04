package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.model.dtos.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioListHandler {

    private final EstudioDao estudioDao;
    private final EstudioMapper estudioMapper;

    public EstudioListHandler(EstudioDao estudioDao, EstudioMapper estudioMapper) {
        this.estudioDao = estudioDao;
        this.estudioMapper = estudioMapper;
    }

    public List<EstudioDTO> execute() {

        List<Estudio> estudioList = estudioDao.getList();

        return estudioList.stream()
                .map(estudioMapper::toDto)
                .toList();

    }

}
