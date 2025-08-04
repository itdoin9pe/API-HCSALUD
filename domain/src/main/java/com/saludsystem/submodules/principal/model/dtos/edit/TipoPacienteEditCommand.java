package com.saludsystem.submodules.principal.model.dtos.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoPacienteEditCommand extends BaseDTO {

    private Long tipoPacienteId;

    private String nombre;

}
