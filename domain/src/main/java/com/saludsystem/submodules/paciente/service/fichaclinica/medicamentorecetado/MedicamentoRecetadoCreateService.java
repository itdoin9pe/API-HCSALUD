package com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado;

import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.port.repository.MedicamentoRecetadoRepository;

public class MedicamentoRecetadoCreateService {

    private final MedicamentoRecetadoRepository medicamentoRecetadoRepository;

    public MedicamentoRecetadoCreateService(MedicamentoRecetadoRepository medicamentoRecetadoRepository) {
        this.medicamentoRecetadoRepository = medicamentoRecetadoRepository;
    }

    public MedicamentoRecetado execute(MedicamentoRecetado medicamentoRecetado) {

        return medicamentoRecetadoRepository.save(medicamentoRecetado);

    }

}
