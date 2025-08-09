package com.saludsystem.submodules.paciente.query.getAll.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NotaAllHandler {

    private final NotaDao notaDao;
    private final NotaMapper notaMapper;

    public NotaAllHandler(NotaDao notaDao, NotaMapper notaMapper) {
        this.notaDao = notaDao;
        this.notaMapper = notaMapper;
    }

    public ListResponse<NotaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = notaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<NotaDTO> data = result.getData()
                .stream()
                .map(notaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
