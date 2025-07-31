package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsentimientoListHandler {

    private final ConsentimientoDao consentimientoDao;
    private final ConsentimientoMapper consentimientoMapper;

    public ConsentimientoListHandler(ConsentimientoDao consentimientoDao, ConsentimientoMapper consentimientoMapper) {
        this.consentimientoDao = consentimientoDao;
        this.consentimientoMapper = consentimientoMapper;
    }

    public List<ConsentimientoDTO> execute() {

        List<Consentimiento> consentimientoList = consentimientoDao.getList();

        return consentimientoList.stream()
                .map(consentimientoMapper::toDto)
                .toList();

    }

}
