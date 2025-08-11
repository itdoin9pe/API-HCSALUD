package com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ConsultaRepository;

public class ConsultaCreateService {

    private final ConsultaRepository consultaRepository;

    public ConsultaCreateService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta execute(Consulta consulta) {

        return consultaRepository.save(consulta);

    }

}
