package com.saludsystem.submodules.principal.model.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarTipoPacienteDTO extends BaseDTO {

    private Long tipoPacienteId;

    private String nombre;

}
