package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.ApoderadoDTO;
import com.saludsystem.application.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.domain.catalogo.model.Apoderado;
import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoderadoAllHandler {

    private final ApoderadoService service;

    public ApoderadoAllHandler(ApoderadoService service) {
        this.service = service;
    }

    public List<ApoderadoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Apoderado> models = service.getAll(hospitalId, page, rows);
        return models.stream()
                .map(ApoderadoMapper::toDto)
                .toList();
    }
}
