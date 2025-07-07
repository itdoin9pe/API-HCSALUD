package com.saludsystem.application.services.paciente;

import com.saludsystem.application.dtos.paciente.get.MedicamentoRecetadoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearMedicamentoRecetadoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface MedicamentoRecetadoService extends GenericService<
        CrearMedicamentoRecetadoDTO,
        MedicamentoRecetadoDTO,
        UUID> {
}