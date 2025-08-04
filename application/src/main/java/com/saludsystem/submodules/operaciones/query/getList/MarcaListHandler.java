package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.model.dtos.MarcaDTO;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcaListHandler {

    private final MarcaDao marcaDao;
    private final MarcaMapper marcaMapper;

    public MarcaListHandler(MarcaDao marcaDao, MarcaMapper marcaMapper) {
        this.marcaDao = marcaDao;
        this.marcaMapper = marcaMapper;
    }

    public List<MarcaDTO> execute() {

        List<Marca> marcaList = marcaDao.getList();

        return marcaList.stream()
                .map(marcaMapper::toDto)
                .toList();

    }

}
