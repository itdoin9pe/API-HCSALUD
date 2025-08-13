package com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta;

import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InformeInterconsultaRepository;

import java.util.UUID;

public class InformeInterDeleteService {

    private final InformeInterconsultaRepository informeInterconsultaRepository;
    private final InformeInterconsultaDao informeInterconsultaDao;

    public InformeInterDeleteService(InformeInterconsultaRepository informeInterconsultaRepository, InformeInterconsultaDao informeInterconsultaDao) {
        this.informeInterconsultaRepository = informeInterconsultaRepository;
        this.informeInterconsultaDao = informeInterconsultaDao;
    }

    public void execute(UUID uuid) {

        var informeInter = informeInterconsultaDao.getById(uuid);

        if (informeInter.getDiagnostico() != null && informeInter.getDiagnostico().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar un informe sin diagnostico");

        }

        informeInterconsultaRepository.delete(uuid);

    }

}
