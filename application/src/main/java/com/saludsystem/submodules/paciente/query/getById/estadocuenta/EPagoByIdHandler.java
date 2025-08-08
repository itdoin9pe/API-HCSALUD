package com.saludsystem.submodules.paciente.query.getById.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EPagoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EPagoDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EPagoByIdHandler {

    private final EPagoDao ePagoDao;
    private final EPagoMapper ePagoMapper;

    public EPagoByIdHandler(EPagoDao ePagoDao, EPagoMapper ePagoMapper) {
        this.ePagoDao = ePagoDao;
        this.ePagoMapper = ePagoMapper;
    }

    public EPagoDTO execute(UUID uuid) {

        var ePago = ePagoDao.getById(uuid);

        if (ePago == null) {

            throw new IllegalArgumentException(EPagoConstant.INVALID_ID);

        }

        return ePagoMapper.toDto(ePago);

    }

}
