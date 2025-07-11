package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoDeleteHandler {

    private final ApoderadoService service;

    public ApoderadoDeleteHandler(ApoderadoService service) {
        this.service = service;
    }

    public void execute(UUID id) {
        service.delete(id);
    }
}