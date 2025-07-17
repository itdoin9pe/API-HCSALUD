package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoAllHandler {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoAllHandler(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public List<ConsentimientoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Consentimiento> models = consentimientoDao.getAll(hospitalId, page, rows);
        return models.stream().map(ConsentimientoMapper::toDto).toList();
    }
}