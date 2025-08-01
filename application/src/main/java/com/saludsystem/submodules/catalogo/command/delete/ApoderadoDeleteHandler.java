package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoDeleteHandler {

    private final ApoderadoDeleteService apoderadoDeleteService;

    public ApoderadoDeleteHandler(ApoderadoDeleteService apoderadoDeleteService) {
        this.apoderadoDeleteService = apoderadoDeleteService;
    }

    public void execute(UUID uuid) {
        apoderadoDeleteService.execute(uuid);
    }

}