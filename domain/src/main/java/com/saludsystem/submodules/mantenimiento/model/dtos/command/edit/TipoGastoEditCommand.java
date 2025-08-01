package com.saludsystem.submodules.mantenimiento.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoGastoEditCommand extends BaseDTO {

    private UUID conceptoGastoId;

    private String nombre;

    @Schema(description = "Estado de Tipos de gastos (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
