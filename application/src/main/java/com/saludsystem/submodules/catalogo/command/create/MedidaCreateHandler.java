package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearMedidaDTO;
import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.MedidaService;
import org.springframework.stereotype.Component;

@Component
public class MedidaCreateHandler {
    private final MedidaService medidaService;

    public MedidaCreateHandler(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    public void execute(CrearMedidaDTO dto) {
        medidaService.save(MedidaMapper.fromCreatDto(dto));
    }
}
