package com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.AntecedenteRespository;

public class AntecedenteCreateService {

    private final AntecedenteRespository antecedenteRespository;

    public AntecedenteCreateService(AntecedenteRespository antecedenteRespository) {
        this.antecedenteRespository = antecedenteRespository;
    }

    public Antecedente execute(Antecedente antecedente) {

        return antecedenteRespository.save(antecedente);

    }

}
