package com.saludsystem.submodules.paciente.service.historia.evolucion.nota;

import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.NotaRepository;

public class NotaDeleteService {

    private final NotaRepository notaRepository;
    private final NotaDao notaDao;

    public NotaDeleteService(NotaRepository notaRepository, NotaDao notaDao) {
        this.notaRepository = notaRepository;
        this.notaDao = notaDao;
    }

    public void execute(Long id) {

        var nota = notaDao.getById(id);

        if (nota.getContenido() != null && nota.getContenido().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar una nota con contenido vacio");

        }

        notaRepository.delete(id);

    }

}
