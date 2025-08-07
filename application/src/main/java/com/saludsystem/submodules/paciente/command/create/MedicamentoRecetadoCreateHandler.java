package com.saludsystem.submodules.paciente.command.create;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.MedicamentoRecetadoCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoCreateService;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoRecetadoCreateHandler {

    private final MedicamentoRecetadoCreateService medicamentoRecetadoCreateService;
    private final MedicamentoRecetadoMapper medicamentoRecetadoMapper;

    public MedicamentoRecetadoCreateHandler(MedicamentoRecetadoCreateService medicamentoRecetadoCreateService, MedicamentoRecetadoMapper medicamentoRecetadoMapper) {
        this.medicamentoRecetadoCreateService = medicamentoRecetadoCreateService;
        this.medicamentoRecetadoMapper = medicamentoRecetadoMapper;
    }

    public void execute(MedicamentoRecetadoCreateCommand createCommand) {

        var medicamentoRecetadoSaved = medicamentoRecetadoMapper.fromCreateDto(createCommand);

        medicamentoRecetadoCreateService.execute(medicamentoRecetadoSaved);

    }

}
