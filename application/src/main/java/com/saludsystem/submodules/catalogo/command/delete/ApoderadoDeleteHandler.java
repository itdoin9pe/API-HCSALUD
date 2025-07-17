package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoDeleteHandler {

    private final ApoderadoDao service;

    public ApoderadoDeleteHandler(ApoderadoDao service) {
        this.service = service;
    }

    public void execute(UUID id) {
        service.delete(id);
    }
}