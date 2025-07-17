package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoderadoAllHandler {

    private final ApoderadoDao service;

    public ApoderadoAllHandler(ApoderadoDao service) {
        this.service = service;
    }

    public List<ApoderadoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Apoderado> models = service.getAll(hospitalId, page, rows);
        return models.stream()
                .map(ApoderadoMapper::toDto)
                .toList();
    }
}
