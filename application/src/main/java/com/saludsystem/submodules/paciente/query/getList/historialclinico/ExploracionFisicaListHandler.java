package com.saludsystem.submodules.paciente.query.getList.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExploracionFisicaListHandler {

    private final ExploracionFisicaDao exploracionFisicaDao;
    private final ExploracionFisicaMapper exploracionFisicaMapper;

    public ExploracionFisicaListHandler(ExploracionFisicaDao exploracionFisicaDao, ExploracionFisicaMapper exploracionFisicaMapper) {
        this.exploracionFisicaDao = exploracionFisicaDao;
        this.exploracionFisicaMapper = exploracionFisicaMapper;
    }

    public List<ExploracionFisicaDTO> execute() {

        List<ExploracionFisica> exploracionFisicaList = exploracionFisicaDao.getList();

        return exploracionFisicaList.stream()
                .map(exploracionFisicaMapper::toDto)
                .toList();

    }

}
