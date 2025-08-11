package com.saludsystem.submodules.paciente.query.getById.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.AntecedenteConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.AntecedenteDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AntecedenteByIdHandler {

    private final AntecedenteDao antecedenteDao;
    private final AntecedenteMapper antecedenteMapper;

    public AntecedenteByIdHandler(AntecedenteDao antecedenteDao, AntecedenteMapper antecedenteMapper) {
        this.antecedenteDao = antecedenteDao;
        this.antecedenteMapper = antecedenteMapper;
    }

    public AntecedenteDTO execute(UUID uuid) {

        var antecedente = antecedenteDao.getById(uuid);

        if (antecedente == null) {

            throw new IllegalArgumentException(AntecedenteConstant.INVALID_ID);

        }

        return antecedenteMapper.toDto(antecedente);

    }

}
