package com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InformeInterconsultaRepository;

public class InformeInterCreateService {

    private final InformeInterconsultaRepository informeInterconsultaRepository;

    public InformeInterCreateService(InformeInterconsultaRepository informeInterconsultaRepository) {
        this.informeInterconsultaRepository = informeInterconsultaRepository;
    }

    public InformeInterconsulta execute(InformeInterconsulta informeInterconsulta) {

        return informeInterconsultaRepository.save(informeInterconsulta);

    }

}
