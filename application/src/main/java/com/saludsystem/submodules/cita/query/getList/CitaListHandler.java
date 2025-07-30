package com.saludsystem.submodules.cita.query.getList;

import com.saludsystem.submodules.cita.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.service.CitaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitaListHandler {

    private final CitaListService citaListService;

    public CitaListHandler(CitaListService citaListService) {
        this.citaListService = citaListService;
    }

    public List<CitaDTO> execute() {

        return citaListService.execute();

    }

}
