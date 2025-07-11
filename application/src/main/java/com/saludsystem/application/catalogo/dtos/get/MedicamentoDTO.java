package com.saludsystem.application.catalogo.dtos.get;

import com.saludsystem.application.catalogo.dtos.post.CrearMedicamentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoDTO extends CrearMedicamentoDTO {
    private UUID medicamentoId;
}