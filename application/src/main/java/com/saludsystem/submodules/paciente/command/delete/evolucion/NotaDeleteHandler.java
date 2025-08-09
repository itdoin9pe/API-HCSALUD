package com.saludsystem.submodules.paciente.command.delete.evolucion;

import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaDeleteService;
import org.springframework.stereotype.Component;

@Component
public class NotaDeleteHandler {

    private final NotaDeleteService notaDeleteService;

    public NotaDeleteHandler(NotaDeleteService notaDeleteService) {
        this.notaDeleteService = notaDeleteService;
    }

    public void execute(Long id) {

        notaDeleteService.execute(id);

    }

}
