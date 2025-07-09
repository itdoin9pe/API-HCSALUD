package com.saludsystem.catalogo.application.dtos.get;

import com.saludsystem.catalogo.application.dtos.post.CrearMedicamentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoDTO extends CrearMedicamentoDTO {
    private UUID medicamentoId;
}