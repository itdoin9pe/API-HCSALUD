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
public class ConsentimientoEditCommand extends BaseDTO {
    private UUID consentimientoId;
    private String nombre;

    private String observacion;

    private String texto;

    @Schema(description = "estado del consentimiento", example = "0")
    private Integer estado;
}