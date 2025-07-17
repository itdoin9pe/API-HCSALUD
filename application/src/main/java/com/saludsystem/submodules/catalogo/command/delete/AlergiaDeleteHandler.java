package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.alergia.AlergiaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaDeleteHandler {

    private final AlergiaDeleteService alergiaDeleteService;

    public AlergiaDeleteHandler(AlergiaDeleteService alergiaDeleteService) {
        this.alergiaDeleteService = alergiaDeleteService;
    }

    public void execute(UUID uuid){
        alergiaDeleteService.execute(uuid);
    }
}