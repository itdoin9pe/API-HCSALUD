package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CajaListHandler {

    private final CajaDao cajaDao;
    private final CajaMapper cajaMapper;

    public CajaListHandler(CajaDao cajaDao, CajaMapper cajaMapper) {
        this.cajaDao = cajaDao;
        this.cajaMapper = cajaMapper;
    }

    public List<CajaDTO> execute() {

        List<Caja> cajaList = cajaDao.getList();

        return cajaList.stream()
                .map(cajaMapper::toDto)
                .toList();

    }

}
