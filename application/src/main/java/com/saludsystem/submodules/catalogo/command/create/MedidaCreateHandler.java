package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.MedidaCreateCommand;
import com.saludsystem.submodules.catalogo.service.medida.MedidaCreateService;
import org.springframework.stereotype.Component;

@Component
public class MedidaCreateHandler {

    private final MedidaCreateService medidaCreateService;
    private final MedidaMapper medidaMapper;

    public MedidaCreateHandler(MedidaCreateService medidaCreateService, MedidaMapper medidaMapper) {
        this.medidaCreateService = medidaCreateService;
        this.medidaMapper = medidaMapper;
    }

    public void execute(MedidaCreateCommand createCommand) {

        var medida = medidaMapper.fromCreatDto(createCommand);

        medidaCreateService.execute(medida);

    }

}
