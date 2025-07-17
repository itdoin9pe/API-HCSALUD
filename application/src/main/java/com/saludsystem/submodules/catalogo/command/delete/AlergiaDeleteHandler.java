package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaDeleteHandler {

    private final AlergiaDao service;

    public AlergiaDeleteHandler(AlergiaDao service) {
        this.service = service;
    }

    public void execute(UUID id) {
        service.delete(id);
    }
}