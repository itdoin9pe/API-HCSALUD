package com.saludsystem.submodules.catalogo.model.dto.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoConceptoEditCommand extends BaseDTO {
    private UUID tipoConceptoId;
    private String nombre;
    @Schema(description = "Estado del Tipo Concepto (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}