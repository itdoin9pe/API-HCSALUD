package com.saludsystem.submodules.principal.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoPacienteEditCommand extends BaseDTO {

    private Long tipoPacienteId;

    private String nombre;

}
