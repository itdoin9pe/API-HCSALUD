package com.saludsystem.application.paciente.dtos.get;

import com.saludsystem.application.paciente.dtos.post.CrearMedicamentoRecetadoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoRecetadoDTO extends CrearMedicamentoRecetadoDTO {

    private UUID medicamentoRecetadoId;

}