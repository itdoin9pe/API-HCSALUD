package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlergiaListHandler {

    private final AlergiaDao alergiaDao;
    private final AlergiaMapper alergiaMapper;

    public AlergiaListHandler(AlergiaDao alergiaDao, AlergiaMapper alergiaMapper) {
        this.alergiaDao = alergiaDao;
        this.alergiaMapper = alergiaMapper;
    }

    public List<AlergiaDTO> execute() {

        List<Alergia> alergiaList = alergiaDao.getList();

        return alergiaList.stream()
                .map(alergiaMapper::toDto) // Dominio → DTO
                .toList();

    }

}
