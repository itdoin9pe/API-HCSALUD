package com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente;

import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.AntecedenteRespository;

import java.util.UUID;

public class AntecedenteDeleteService {

    private final AntecedenteRespository antecedenteRespository;
    private final AntecedenteDao antecedenteDao;

    public AntecedenteDeleteService(AntecedenteRespository antecedenteRespository, AntecedenteDao antecedenteDao) {
        this.antecedenteRespository = antecedenteRespository;
        this.antecedenteDao = antecedenteDao;
    }

    public void execute(UUID uuid) {

        var antecedente = antecedenteDao.getById(uuid);

        if (antecedente.getTiempoEnfermedad() != null && antecedente.getTiempoEnfermedad().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar un antecedente sin tiempo establecido");

        }

        antecedenteRespository.delete(uuid);

    }

}
