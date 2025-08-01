package com.saludsystem.submodules.catalogo.model.dto.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoCitadoEditCommand extends BaseDTO {
    private UUID tipoCitadoId;
    private String nombre;
    private String color;
    @Schema(description = "Estado del Tipo Citado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}