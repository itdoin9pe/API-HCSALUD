package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnfermedadListHandler {

    private final EnfermedadListService enfermedadListService;

    public EnfermedadListHandler(EnfermedadListService enfermedadListService) {
        this.enfermedadListService = enfermedadListService;
    }

    public List<EnfermedadDTO> execute() {
        return enfermedadListService.execute();
    }

}
