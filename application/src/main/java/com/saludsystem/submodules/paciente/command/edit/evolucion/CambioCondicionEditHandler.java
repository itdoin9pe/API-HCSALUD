package com.saludsystem.submodules.paciente.command.edit.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.CambioCondicionEditCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionEditService;
import org.springframework.stereotype.Component;

@Component
public class CambioCondicionEditHandler {

    private final CambioCondicionEditService cambioCondicionEditService;
    private final CambioCondicionMapper cambioCondicionMapper;

    public CambioCondicionEditHandler(CambioCondicionEditService cambioCondicionEditService, CambioCondicionMapper cambioCondicionMapper) {
        this.cambioCondicionEditService = cambioCondicionEditService;
        this.cambioCondicionMapper = cambioCondicionMapper;
    }

    public void execute(Long id, CambioCondicionEditCommand editCommand) {

        var cambioCondicionUpdated = cambioCondicionMapper.fromUpdateDto(id, editCommand);

        cambioCondicionEditService.execute(id, cambioCondicionUpdated);

    }

}
