package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarMedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaEditHandler {
    private final MedidaDao medidaDao;

    public MedidaEditHandler(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public void execute(UUID uuid, ActualizarMedidaDTO dto) {
        medidaDao.update(uuid, MedidaMapper.fromUpdateDto(uuid, dto));
    }
}
