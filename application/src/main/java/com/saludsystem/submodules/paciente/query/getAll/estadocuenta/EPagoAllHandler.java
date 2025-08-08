package com.saludsystem.submodules.paciente.query.getAll.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EPagoDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EPagoAllHandler {

    private final EPagoDao ePagoDao;
    private final EPagoMapper ePagoMapper;

    public EPagoAllHandler(EPagoDao ePagoDao, EPagoMapper ePagoMapper) {
        this.ePagoDao = ePagoDao;
        this.ePagoMapper = ePagoMapper;
    }

    public ListResponse<EPagoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = ePagoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EPagoDTO> data = result.getData()
                .stream()
                .map(ePagoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
