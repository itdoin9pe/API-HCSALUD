package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InformacionClinicaListHandler {

    private final InformacionClinicaListService informacionClinicaListService;

    public InformacionClinicaListHandler(InformacionClinicaListService informacionClinicaListService) {
        this.informacionClinicaListService = informacionClinicaListService;
    }

    public List<InformacionClinicaDTO> execute() {
        return informacionClinicaListService.execute();
    }

}
