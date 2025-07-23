package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MonedaListHandler {

    private final MonedaListService monedaListService;

    public MonedaListHandler(MonedaListService monedaListService) {
        this.monedaListService = monedaListService;
    }

    public List<MonedaDTO> execute() {
        return monedaListService.execute();
    }
}
