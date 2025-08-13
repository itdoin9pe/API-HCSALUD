package com.saludsystem.submodules.paciente.service.historia.interconsulta;

import com.saludsystem.submodules.paciente.model.constant.interconsulta.InterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InterconsultaRepository;

import java.util.UUID;

public class InterconsultaEditService {

    private final InterconsultaDao interconsultaDao;
    private final InterconsultaRepository interconsultaRepository;

    public InterconsultaEditService(InterconsultaDao interconsultaDao, InterconsultaRepository interconsultaRepository) {
        this.interconsultaDao = interconsultaDao;
        this.interconsultaRepository = interconsultaRepository;
    }

    public Interconsulta execute(UUID uuid, Interconsulta interconsulta) {

        var currentInterconsulta = interconsultaDao.getById(uuid);

        if (currentInterconsulta == null) {

            throw new IllegalArgumentException(InterconsultaConstant.INVALID_ID);

        }

        if (currentInterconsulta.getEstado() != null && currentInterconsulta.getEstado().equals(" ")) {

            throw new IllegalStateException("No se puede actualizar, la interconsulta esta desactivada");

        }

        return interconsultaRepository.update(uuid, interconsulta);

    }

}
