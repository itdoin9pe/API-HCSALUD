package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearMedidaDTO;
import com.saludsystem.application.catalogo.mapper.MedidaMapper;
import com.saludsystem.domain.catalogo.port.in.service.MedidaService;
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
