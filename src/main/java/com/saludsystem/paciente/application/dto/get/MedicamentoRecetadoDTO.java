package com.saludsystem.paciente.application.dto.get;

import com.saludsystem.paciente.application.dto.post.CrearMedicamentoRecetadoDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoRecetadoDTO extends CrearMedicamentoRecetadoDTO {

    private UUID medicamentoRecetadoId;

}