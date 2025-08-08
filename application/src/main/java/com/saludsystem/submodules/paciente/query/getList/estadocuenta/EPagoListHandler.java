package com.saludsystem.submodules.paciente.query.getList.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EPagoDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EPagoListHandler {

    private final EPagoDao ePagoDao;
    private final EPagoMapper ePagoMapper;

    public EPagoListHandler(EPagoDao ePagoDao, EPagoMapper ePagoMapper) {
        this.ePagoDao = ePagoDao;
        this.ePagoMapper = ePagoMapper;
    }

    public List<EPagoDTO> execute() {

        List<EPago> ePagoList = ePagoDao.getList();

        return ePagoList.stream()
                .map(ePagoMapper::toDto)
                .toList();

    }

}
