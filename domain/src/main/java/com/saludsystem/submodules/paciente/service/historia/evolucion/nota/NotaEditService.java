package com.saludsystem.submodules.paciente.service.historia.evolucion.nota;

import com.saludsystem.submodules.paciente.model.constant.evolucion.NotaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.NotaRepository;

public class NotaEditService {

    private final NotaDao notaDao;
    private final NotaRepository notaRepository;

    public NotaEditService(NotaDao notaDao, NotaRepository notaRepository) {
        this.notaDao = notaDao;
        this.notaRepository = notaRepository;
    }

    public Nota execute(Long id, Nota nota) {

        var currentNota = notaDao.getById(id);

        if (currentNota == null) {

            throw new IllegalArgumentException(NotaConstant.INVALID_ID);

        }

        if (currentNota.getContenido() != null && currentNota.getContenido().equals(" ")) {

            throw new IllegalStateException("El contenido de la nota esta vacio");

        }

        return notaRepository.update(id, nota);

    }

}
