package com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente;

import com.saludsystem.submodules.paciente.model.constant.historialclinico.AntecedenteConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.AntecedenteRespository;

import java.util.UUID;

public class AntecedenteEditService {

    private final AntecedenteDao antecedenteDao;
    private final AntecedenteRespository antecedenteRespository;

    public AntecedenteEditService(AntecedenteDao antecedenteDao, AntecedenteRespository antecedenteRespository) {
        this.antecedenteDao = antecedenteDao;
        this.antecedenteRespository = antecedenteRespository;
    }

    public Antecedente execute(UUID uuid, Antecedente antecedente) {

        var currentAntecedente = antecedenteDao.getById(uuid);

        if (currentAntecedente == null) {

            throw new IllegalArgumentException(AntecedenteConstant.INVALID_ID);

        }

        if (currentAntecedente.getMotivo() != null && currentAntecedente.getMotivo().equals(" ")){

            throw new IllegalStateException("El motivo esta vacio");

        }

        return antecedenteRespository.update(uuid, antecedente);

    }

}
