package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PresentacionListHandler {

    private final PresentacionDao presentacionDao;
    private final PresentacionMapper presentacionMapper;

    public PresentacionListHandler(PresentacionDao presentacionDao, PresentacionMapper presentacionMapper) {
        this.presentacionDao = presentacionDao;
        this.presentacionMapper = presentacionMapper;
    }

    public List<PresentacionDTO> execute() {

        List<Presentacion> presentacionList = presentacionDao.getList();

        return presentacionList.stream()
                .map(presentacionMapper::toDto)
                .toList();

    }

}
