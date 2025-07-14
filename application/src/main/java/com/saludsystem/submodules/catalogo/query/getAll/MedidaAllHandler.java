package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.MedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.in.service.MedidaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedidaAllHandler {
    private final MedidaService medidaService;

    public MedidaAllHandler(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    public List<MedidaDTO> execute(UUID hospitalId, int page, int rows) {
        List<Medida> models = medidaService.getAll(hospitalId, page, rows);
        return models.stream().map(MedidaMapper::toDto).toList();
    }
}
