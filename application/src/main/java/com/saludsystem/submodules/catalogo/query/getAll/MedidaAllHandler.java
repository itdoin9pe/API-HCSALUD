package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedidaAllHandler {
    private final MedidaDao medidaDao;

    public MedidaAllHandler(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public List<MedidaDTO> execute(UUID hospitalId, int page, int rows) {
        List<Medida> models = medidaDao.getAll(hospitalId, page, rows);
        return models.stream().map(MedidaMapper::toDto).toList();
    }
}
