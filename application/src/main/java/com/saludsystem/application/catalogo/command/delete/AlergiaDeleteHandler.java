package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.AlergiaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaDeleteHandler {

    private final AlergiaService service;

    public AlergiaDeleteHandler(AlergiaService service) {
        this.service = service;
    }

    public void execute(UUID id) {
        service.delete(id);
    }
}