package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearMedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.MedicamentoService;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoCreateHandler {
    private final MedicamentoService medicamentoService;

    public MedicamentoCreateHandler(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    public void execute(CrearMedicamentoDTO dto){
        medicamentoService.save(MedicamentoMapper.fromCreateDto(dto));
    }
}