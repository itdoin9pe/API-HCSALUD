package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import org.springframework.stereotype.Component;

@Component
public class MedidaCreateHandler {
    private final MedidaDao medidaDao;

    public MedidaCreateHandler(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public void execute(CrearMedidaDTO dto) {
        medidaDao.save(MedidaMapper.fromCreatDto(dto));
    }
}
